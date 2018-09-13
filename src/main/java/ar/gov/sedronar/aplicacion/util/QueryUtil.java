package ar.gov.sedronar.aplicacion.util;

import ar.gov.sedronar.util.dataTable.Column;
import ar.gov.sedronar.util.dataTable.ColumnOrder;
import ar.gov.sedronar.util.dataTable.DataTablePagingRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryUtil {

    public static Map<String, Boolean> getColumnOrders(DataTablePagingRequest filtro) {
        Map<String, Boolean> sortOrder = new HashMap<>();
        for (ColumnOrder order : filtro.getOrder()) {
            Column column = filtro.getColumns().get(order.getColumn());
            sortOrder.put(column.getData(), order.getDir().equals("asc"));
        }

        return sortOrder;
    }

}
