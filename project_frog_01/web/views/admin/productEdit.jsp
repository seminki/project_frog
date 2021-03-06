<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.toyspace.product.model.vo.*, java.util.TreeSet"%> 

<%
	Product p=(Product)request.getAttribute("product");

	TreeSet<Tags> tagsList= (TreeSet<Tags>)request.getAttribute("tagsList");
	TreeSet<Tags> itemTags= (TreeSet<Tags>)request.getAttribute("itemTags");
	
	
%>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
  <style>
      section.enroll-container {
        text-align: center;
      }
      section.enroll-container input {
        margin: 3px;
      }
      section.enroll-container table {
        margin: 0 auto;
      }
      section.enroll-container table th {
        padding: 0 10px;
        text-align: right;
      }
      section.enroll-container table td {
        padding: 0 10px;
        text-align: left;
      }
      div.search-container {
        margin: 0 0 10px 0;
        padding: 3px;
        background-color: rgb(0, 0, 0);
        color: white;
        height: 22px;
      }
      .input-hidden-for-add {
        display: none;
      }

      .img-preview-container {
        width: 40em;
        height: 6em;
        display: flex;
        align-content: center;
      }

      .img-preview {
        width: 5em;
        height: 5em;
        border: gray 2px dotted;
        border-radius: 5px;
        background-color: black;
      }
      .tag-list-container {
        overflow: auto;
        width: 60%;
        height: 15em;
        border: black 1px solid;
      }
      .tag-list {
        width: 100%;
        border-collapse: collapse;
      }
      .tag-list * {
        border: gray 1px solid;
      }
    </style>

    <section class="enroll-container">
      <h2>상품수정</h2>
      <div class="search-container">☆☆☆☆☆</div>
      <form action="<%=request.getContextPath() %>/admin/editProductEnd" method="post">
        <br />
        <table>
          <tr>
            <th>상품ID</th>
            <td>
              <input type="text" placeholder="" name="productId" value="<%=p.getProductId()%>" readonly /><br />
            </td>
          </tr>
          <tr>
            <th>상품명</th>
            <td>
              <input
                type="text"
                placeholder=""
                name="item_name"
                value=<%=p.getProductName() %>
                required
              /><br />
            </td>
          </tr>
          <tr>
            <th>상품 카테고리</th>
            <td>
              <select name="category" class="category">
              	<option value="1">디즈니</option>
              	<option value="2">스타워즈</option>
              	<option value="3">왕좌의게임</option>
              	<option value="4">포켓몬스터</option>
              	<option value="5">마블</option>
              	
              </select>
            </td>
          </tr>
          <tr>
            <th>상품 가격</th>
            <td>
              <input
                type="number"
                placeholder="0원이상"
                name="item_price"
                min="0"
                value=<%=p.getProductPrice() %>
                required
              /><br />
            </td>
          </tr>
          <tr>
            <th>상품 개수</th>
            <td><input type="number" name="item_qt" value=<%=p.getProductStock() %> required /><br /></td>
          </tr>
<%--           <tr>
            <th></th>
            <td>
              <div class="img-preview-container">
              <%for(int i=0;i<p.getProductImageFilePaths().size();i++){ %>
                <img alt="" src="<%=request.getContextPath()%>/upload/product/<%=p.getProductImageFilePaths().get(i) %>" class="img-preview" /> 
                <%} %>
                <img alt="" src="" class="img-preview" />
                <img alt="" src="" class="img-preview" />
                <img alt="" src="" class="img-preview" />
              </div>
            </td>
          </tr>
          <tr>
            <th>상품 메인사진</th>
            <td>
              <input
                type="file"
                name="upload-file1"
               
                class="img-file-input"
              /><br />
            </td>
          </tr>
          <tr>
            <th>상품 추가사진</th>
            <td>
              <div>
                <input type="file" name="upload-file2" class="img-file-input" />
                <input
                  type="button"
                  class="file-add-button"
                  value="파일 추가"
                  onclick="inputAdd(event);"
                />
              </div>
            </td>
            <td class="input-hidden-for-add">
              <div>
                <input type="file" name="upload-file" class="img-file-input" />
                <input
                  type="button"
                  class="file-add-button"
                  onclick="inputAdd(event);"
                  value="파일 추가"
                />
                <input
                  type="button"
                  value="제거"
                  onclick="removeInput(event);"
                />
              </div>
            </td>
          </tr>
          --%>
          <tr>
            <th>상품 태그 목록</th>
            <td>
              <div class="tag-list-container">
                <table class="tag-list">
                  <tr>
                    <th>태그 번호</th>
                    <th>태그 명</th>
                  </tr>
                  <% if(tagsList!=null&&tagsList.size()!=0){ for(Tags t :
                  tagsList){ %>
                  <tr>
                    <td><%=t.getTagNo() %></td>
                    <td><%=t.getTagName() %></td>
                  </tr>
                  <%} }%>
                </table>
              </div>
            </td>
          </tr>
          <tr>
            <th>상품 태그 번호</th>
            <td>
              <% 
              	int i =0;
              if(itemTags!=null&&itemTags.size()!=0){ 
            	  for(Tags t : itemTags){ %>
              <input type="text" name="item_tag" required size="5" value="<%=t.getTagNo() %>" />
            <%
            	i++;
            	  } } 
           	for(;i<4;i++){ %>
           		<input type="text" name="item_tag" required size="5"/>
           	<%}
            %>
            </td>
          </tr> 
          <tr>
            <th>상품 설명</th>
            <td>
              <textarea
                rows="20"
                cols="50"
                placeholder="띄어쓰기는 &#60;br&#62;로 표시"
                name="product-description"
                ><%=p.getProductDescription() %></textarea>
            </td>
          </tr>
          <tr>
            <th>제조사</th>
            <td>
              <input type="text" name="manufacturer" value=<%=p.getManufacturer() %>/>
            </td>
          </tr>
          <tr>
            <th>제조국</th>
            <td>
              <input type="text" name="manufactured-country" value=<%=p.getManufacturedCountry() %> />
            </td>
          </tr>
          <tr>
            <th>권장 연령</th>
            <td>
              <input type="number" name="recommended-age" min="0" value="<%=p.getRecommendedAge() %>"/>
            </td>
          </tr>
          <tr>
            <th>주의사항</th>
            <td>
              <textarea
                rows="20"
                cols="50"
                placeholder="띄어쓰기는 &#60;br&#62;로 표시"
                name="caution"
              ><%=p.getCaution() %></textarea>
            </td>
          </tr>
        </table>
        <input type="submit" value="수정" />
        <input type="reset" value="취소" onclick="self.close();" />
      </form>
    </section>
 <script>

$(".category option:selected").val();
 
 
 function inputAdd(e) {
		const fileInputCont = $(e.target).parent().parent();
		let fileInputCode = $(".input-hidden-for-add>div").clone();
		if (fileInputCont.children().length < 4) {
			// 파일 순서를 찾기 위한 이벤트 설정 - 프리뷰용
			$(fileInputCode.children()[0])
				.unbind()
				.change((e) => {
					fileIndexInsert(e, fileInputCont.children().length);
				});
			$($(fileInputCode).children()[0]).removeAttr("name")
			.attr("name","upload-sub-file"+(fileInputCont.children().length+2));
			console.log($($(fileInputCode).children()[0]));
			fileInputCont.append(fileInputCode);
		} else {
			alert("등록할 수 있는 파일 수는 5개까지 입니다!");
		}
	}
	function removeInput(e) {
		const removedInput = $(e.target).parent();
		/* 인풋의 내용을 강제 변경시켜 프리뷰의 체인지 이벤트 강제하기 */
		$(removedInput).children()[0].value="";
		$($(removedInput).children()[0]).trigger("change");
		removedInput.remove();
	}
	$(".img-file-input").each((i, v) => {
		$(v).change((e) => {
			fileIndexInsert(e, i);
		});
	});
	function fileIndexInsert(e, i) {
		let file = e.target.files[0];
		if (file == null) {
			$($(".img-preview")[i]).attr(
				"src",
				"<%=request.getContextPath() %>/image/common/blacklogo.png"
			);
			return;
		}
		if (!file.type.match("image.*")) {
			alert("이미지만 등록 가능합니다!");
			e.target.value = "";
			return;
		}
		let reader = new FileReader();
		reader.onload = function (e) {
			$($(".img-preview")[i]).attr("src", e.target.result);
		};
		reader.readAsDataURL(file);
	}
 </script>
</body>
</html>