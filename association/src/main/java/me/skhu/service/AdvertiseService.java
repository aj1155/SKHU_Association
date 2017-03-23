package me.skhu.service;

import java.text.ParseException;
import java.util.List;

import me.skhu.domain.AdvertiseCategory;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import me.skhu.domain.Advertise;
import me.skhu.domain.dto.AdvertiseDto;
import me.skhu.domain.dto.AdvertiseListDto;
import me.skhu.repository.AdvertiseCategoryRepository;
import me.skhu.repository.AdvertiseRepository;
import me.skhu.util.Pagination;

@Service
public class AdvertiseService {

	@Autowired
	private AdvertiseRepository advertiseRepository;

	@Autowired
	private AdvertiseCategoryRepository advertiseCategoryRepository;

	@Autowired
	private FileService fileService;

	public AdvertiseListDto findAll(Pagination pagination,int categoryId){
		switch(pagination.getSrchType()){
			case 0 :
				System.out.println("pagination");
				pagination.setRecordCount(advertiseRepository.countByPagination(categoryId));
				return AdvertiseListDto.of(advertiseRepository.pagination(pagination, categoryId));
			case 1 :
				System.out.println("pagination slogan");
				pagination.setRecordCount(advertiseRepository.countBySlogan(pagination.getSrchText(), categoryId));
				return AdvertiseListDto.of(advertiseRepository.paginationBySlogan(pagination, categoryId));
			case 2:
				System.out.println("company");
				pagination.setRecordCount(advertiseRepository.countByCompany(pagination.getSrchText(),categoryId));
				return AdvertiseListDto.of(advertiseRepository.paginationByCompany(pagination,categoryId));
			default :
				System.out.println("defualt");
				pagination.setRecordCount(advertiseRepository.countByUserName(pagination.getSrchText(), categoryId));
                return AdvertiseListDto.of(advertiseRepository.paginationByUserName(pagination, categoryId));
		}
	}

	@Transactional(readOnly = false)
	public int create(AdvertiseDto advertiseDto,MultipartHttpServletRequest request, MultipartFile file) throws ParseException{
		String imagePath = fileService.imageUpload(file,request);
		try {
			advertiseRepository.save(Advertise.of(advertiseDto,advertiseCategoryRepository.findById(advertiseDto.getCategoryId()),imagePath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advertiseDto.getCategoryId();
	}

	@Transactional(readOnly = false)
	public void deleted(int id){
		advertiseRepository.delete(id);
	}

	public void edit(AdvertiseDto advertiseDto){
		//advertiseRepository.save(advertiseDto);
	}

	public AdvertiseDto findById(int id){
		return AdvertiseDto.of(advertiseRepository.findOne(id));
	}

	@Transactional(readOnly = false)
	public void groupDelete(List<Integer> list){
		for(int i : list)
			advertiseRepository.delete(i);
	}

	public boolean deleteCategoryName(String name){
		AdvertiseCategory advertise =advertiseCategoryRepository.findByName(name);
		if(advertise==null)
			return false;
		else{
			advertiseRepository.deleteByCategoryId(advertise.getId());
			advertiseCategoryRepository.delete(advertise);
		}
		return true;
	}
}
