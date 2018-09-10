package ar.gov.sedronar.aplicacion.filters;

import ar.gov.sedronar.util.dataTable.DataTablePagingRequest;

/**
 * Created by TMR on 10/09/2018.
 */
public class ConsultaTableFilter extends DataTablePagingRequest {
    private ConsultaFilter filter;

    public ConsultaFilter getFilter() {
        return filter;
    }

    public void setFilter(ConsultaFilter filter) {
        this.filter = filter;
    }
}
