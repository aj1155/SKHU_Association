<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="main">
	<div class="inner">
		<h2>임원 추가</h2>
		<hr/>
		<form method="post">
			<div class="table-wrapper">
				<table>
					<tr>
						<td>임원 유형</td>
						<td>
							<select name="type">
								<option value="총동문">전체</option>
								<option value="기수">기수</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>직책명</td>
						<td><input type="text" name="name"/></td>
					</tr>
				</table>
			</div>
			<hr />
			<div class="form-group">
					<ul class="actions">
						<li><button type="submit" class="button special">저장</button></li>
						<li><a href="typeList" class="button">취소</a></li>
					</ul>
			</div>
			
		</form>
	</div>
</div>