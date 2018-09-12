package ar.gov.sedronar.aplicacion.filters;

import ar.gov.sedronar.util.dataTable.DataTablePagingRequest;

public class GeneralTableFilter extends DataTablePagingRequest {

    private GeneralFilter filter;

    public GeneralFilter getFilter() {
        return filter;
    }

    public void setFilter(GeneralFilter filter) {
        this.filter = filter;
    }
}
