package com.toyspace.common.model.vo;

import javax.servlet.http.HttpServletRequest;

public class Page {
	
	private int cPage;
	private int numPerPage;
	private int totalData;
	private int totalPage;
	private int pageBarSize;
	private int pageNo;
	private int pageEnd;
	private String loc;
	private String pageBar;
	
	public Page() {
		// TODO Auto-generated constructor stub
	}

	public Page(int cPage, int numPerPage, int totalData, int pageBarSize, HttpServletRequest request, String loc) {
		super();
		this.cPage = cPage;
		this.numPerPage = numPerPage;
		this.totalData = totalData;
		this.pageBarSize = pageBarSize;
		this.loc = request.getContextPath()+loc;
		
		totalPage = (int)Math.ceil((double)totalData/numPerPage);
		pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		pageEnd =pageNo+pageBarSize-1;
		
		pageBar = "";
		if(pageNo ==1) {
			pageBar+="<button>" + 
					"<span " + 
					"aria-hidden=\"true\">PREV</span> <span" + 
					"aria-hidden=\"true\"><i" + 
					"class=\"fas fa-chevron-left\"></i></span>" + 
					"</button>";
		} else {
			pageBar+="<a href='"+this.loc+"?cPage="
					+(pageNo-1)+"'><button>"+ 
					"					<span " + 
					"					aria-hidden=\"true\">PREV</span> <span " + 
					"					aria-hidden=\"true\"><i " + 
					"					class=\"fas fa-chevron-left\"></i></span>" + 
					"					</button></a>";	
		}
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+=" "+"<button>"+pageNo+"</button>"+" ";
			}else {
				pageBar+=" "+"<a href='"+this.loc+"?cPage="+pageNo+"'><button>"+pageNo+"</button></a>"+" ";	
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<button>" + 
					"<span " + "aria-hidden=\"true\">NEXT</span> <span " + 
					"aria-hidden=\"true\"><i " + 
					"class=\"fas fa-chevron-right\"></i></span>" + 
					"</button>";
		}else {
			pageBar+="<a href='"+this.loc+"?cPage="+pageNo+"'><button>" + 
					"					<span " + "aria-hidden=\"true\">NEXT</span> <span " +
					"					aria-hidden=\"true\"><i " + 
					"					class=\"fas fa-chevron-right\"></i></span> " + 
					"					</button></a>";
		}
	}

	public int getcPage() {
		return cPage;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public int getTotalData() {
		return totalData;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getPageBarSize() {
		return pageBarSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public String getLoc() {
		return loc;
	}

	public String getPageBar() {
		return pageBar;
	}

	@Override
	public String toString() {
		return "Page [cPage=" + cPage + ", numPerPage=" + numPerPage + ", totalData=" + totalData + ", totalPage="
				+ totalPage + ", pageBarSize=" + pageBarSize + ", pageNo=" + pageNo + ", pageEnd=" + pageEnd + ", loc="
				+ loc + ", pageBar=" + pageBar + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		if (cPage != other.cPage)
			return false;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		if (numPerPage != other.numPerPage)
			return false;
		if (pageBar == null) {
			if (other.pageBar != null)
				return false;
		} else if (!pageBar.equals(other.pageBar))
			return false;
		if (pageBarSize != other.pageBarSize)
			return false;
		if (pageEnd != other.pageEnd)
			return false;
		if (pageNo != other.pageNo)
			return false;
		if (totalData != other.totalData)
			return false;
		if (totalPage != other.totalPage)
			return false;
		return true;
	}
	
}
