package ar.gov.sedronar.aplicacion.filters;

import ar.gov.sedronar.util.dataTable.DataTablePagingRequest;

public class VencimientoTableFilter extends DataTablePagingRequest {

    private VencimientoFilter filter;

    public VencimientoFilter getFilter() {
        return filter;
    }

    public void setFilter(VencimientoFilter filter) {
        this.filter = filter;
    }


}
