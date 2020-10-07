<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
      <h2>태그등록</h2>
      <form name="addTagFrm" action="" method>
        <table>
          <tr>
            <th>상품ID</th>
            <td>
              <select class="searchType">
                <option value="itemId">0001A</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>등록할 태그명</th>
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