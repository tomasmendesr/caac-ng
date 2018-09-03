package ar.gov.sedronar.util.dataTable;

import javax.servlet.http.HttpServletRequest;

public class DataTableUtils {

	public static String getOrderColumn(Integer index, HttpServletRequest request){
		String colIndex = request.getParameter(String.format("order[%d][column]", index));
		String colIndex2 = request.getParameter(String.format("columns[%d][column]", index));
		String colData = request.getParameter(String.format("columns[%d][data]", index));
		return colData;
	}
	
	public static Boolean getOrderDirection(Integer index, HttpServletRequest request){
		String direction = request.getParameter(String.format("order[%d][dir]", index));
		return direction.equals("asc");
	}
	
	public static Integer getDraw(HttpServletRequest request){
		return Integer.decode(request.getParameter("draw"));
	}
}
