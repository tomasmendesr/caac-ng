package ar.gov.sedronar.util.dataTable;

import java.util.List;

public class DataTablePagingRequest {
	protected Integer draw;
	protected List<Column> columns;
	protected List<ColumnOrder> order;
	protected Integer start;
	protected Integer length;
	protected SearchField search;
	
	
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	public List<ColumnOrder> getOrder() {
		return order;
	}
	public void setOrder(List<ColumnOrder> order) {
		this.order = order;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public SearchField getSearch() {
		return search;
	}
	public void setSearch(SearchField search) {
		this.search = search;
	}
	
	
}
