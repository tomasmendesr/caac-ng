package ar.gov.sedronar.util.dataTable;

import java.util.Collection;

public class DataTableObjectResponse {
	protected Collection<?> data;
	protected Integer draw;
	protected Integer recordsFiltered;
	protected Integer recordsTotal;
	
	
	public DataTableObjectResponse(Collection<?> data, Integer draw, Integer recordsFiltered, Integer recordsTotal) {
		super();
		this.data = data;
		this.draw = draw;
		this.recordsFiltered = recordsFiltered;
		this.recordsTotal = recordsTotal;
	}
	
	public Collection<?> getData() {
		return data;
	}
	public void setData(Collection<?> data) {
		this.data = data;
	}
	
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	
	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	
	public Integer getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	
	
}
