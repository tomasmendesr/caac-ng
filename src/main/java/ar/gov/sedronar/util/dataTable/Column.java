package ar.gov.sedronar.util.dataTable;

public class Column {
	protected String data;
	protected String name;
	protected Boolean searchable;
	protected Boolean orderable;
	protected SearchField search;
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getSearchable() {
		return searchable;
	}
	public void setSearchable(Boolean searchable) {
		this.searchable = searchable;
	}
	public Boolean getOrderable() {
		return orderable;
	}
	public void setOrderable(Boolean orderable) {
		this.orderable = orderable;
	}
	public SearchField getSearch() {
		return search;
	}
	public void setSearch(SearchField search) {
		this.search = search;
	}
	
	
}
