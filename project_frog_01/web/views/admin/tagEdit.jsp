<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<script src='http://code.jquery.com/jquery-3.5.1.min.js'></script>
<meta charset="UTF-8">
 <title>태그등록</title>
    <style>
      div.addTag-container {
        border: 2px black solid;
      }
      div.addTag-container table {
        margin: 0 auto;
        border-spacing: 20px;
      }
      div.addTag-container table tr:last-of-type td {
        text-align: center;
      }
      div.addTag-container h2 {
        text-align: center;
      }
    </style>
  </head>
 <body>
    <div class="addTag-container">
      <h2>태그 수정</h2>
      <form name="addTagFrm" action="" method>
        <table>
          <tr>
            <th>기존 태그명</th>
            <td>
            	기존 태그명 불러올까 ?
            </td>
          </tr>
          <tr>
            <th>새 태그명</th>
            <td>
              <input type="text" name="newTag" id="tag" />
            </td>
          </tr>

          <tr>
            <td colspan="2">
              <input type="submit" value="등록" onclick="" />&nbsp;
              <input type="button" value="닫기" onclick="self.close();" />
            </td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>