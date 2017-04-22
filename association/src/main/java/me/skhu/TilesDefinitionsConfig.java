package me.skhu;

import java.util.HashMap;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TilesDefinitionsConfig implements DefinitionsFactory{

	private static final Map<String, Definition> tilesDefinitions = new HashMap<String, Definition>();
	private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/views/template.jsp");
	private static final Attribute AJAX_TEMPLATE = new Attribute("/WEB-INF/views/templateAjax.jsp");

	@Override
	public Definition getDefinition(String name,Request tilesContext){
		return tilesDefinitions.get(name);
	}

	private static void addDefaultLayoutDef(String name, String content){
		Map<String, Attribute> attributes = new HashMap<String, Attribute>();

		attributes.put("header", new Attribute("/WEB-INF/views/commons/header.jsp"));
		attributes.put("menu",new Attribute("/WEB-INF/views/commons/menu.jsp"));
		attributes.put("content",new Attribute("/WEB-INF/views/"+content+".jsp"));
		tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
	}

	public static void addDefaultAjaxDef(String name, String content){
		Map<String, Attribute> attributes = new HashMap<String, Attribute>();

		attributes.put("content", new Attribute("/WEB-INF/views/"+content+".jsp"));
		tilesDefinitions.put(name, new Definition(name, AJAX_TEMPLATE, attributes));
	}

	public static void addDefinitions(){
		addDefaultLayoutDef("user/list","user/list");
		addDefaultLayoutDef("user/edit","user/edit");
		addDefaultLayoutDef("user/createType","user/createType");
		addDefaultLayoutDef("user/typeList","user/typeList");

		addDefaultLayoutDef("admin/excelUpload","admin/excelUpload");

		addDefaultLayoutDef("advertise/create","advertise/create");
		addDefaultLayoutDef("advertise/edit","advertise/edit");
		addDefaultLayoutDef("advertise/home","advertise/home");
		addDefaultLayoutDef("advertise/list","advertise/list");

		addDefaultLayoutDef("board/list","board/list");
		addDefaultLayoutDef("board/edit","board/edit");
		addDefaultLayoutDef("board/read","board/read");
		addDefaultLayoutDef("board/write","board/write");

		addDefaultLayoutDef("user/userEditDetail","user/userEditDetail");

		addDefaultLayoutDef("admin/save","admin/save");
		addDefaultLayoutDef("admin/value","admin/value");

		addDefaultLayoutDef("user/userEditList","user/userEditList");
		addDefaultLayoutDef("user/phoneNumberEditList", "user/phoneNumberEditList");

		addDefaultLayoutDef("admin/introduceEdit","admin/introduceEdit");
		addDefaultLayoutDef("admin/introduce2","admin/introduce2"); //관리자웹페이지용

		addDefaultLayoutDef("user/createByExcel","user/createByExcel");

		addDefaultLayoutDef("admin/list","admin/list");
		addDefaultLayoutDef("admin/edit","admin/edit");
		addDefaultLayoutDef("admin/myInfo","admin/myInfo");
		addDefaultLayoutDef("admin/mailSend","admin/mailSend");

		// Ajax
		addDefaultAjaxDef("admin/mailList","admin/mailList");
		addDefaultAjaxDef("home/login","home/login");
		addDefaultAjaxDef("admin/introduce","admin/introduce"); // 모바일 웹뷰용

	}

}
