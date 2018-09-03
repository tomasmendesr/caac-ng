package ar.gov.sedronar.aplicacion.filters;

import ar.gov.sedronar.util.dataTable.DataTablePagingRequest;

/**
 * Created by TMR on 30/08/2018.
 */
public class AbstractTableFilter extends DataTablePagingRequest {
    private AbstractFilter filter;

    public AbstractFilter getFilter() {
        return filter;
    }

    public void setFilter(AbstractFilter filter) {
        this.filter = filter;
    }
}
