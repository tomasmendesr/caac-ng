package ar.gov.sedronar.aplicacion.filters;

import ar.gov.sedronar.util.dataTable.DataTablePagingRequest;

public class AdministrativoTableFilter extends DataTablePagingRequest {

    private AdministrativoFilter filter;

    public AdministrativoFilter getFilter() {
        return filter;
    }

    public void setFilter(AdministrativoFilter filter) {
        this.filter = filter;
    }

}
