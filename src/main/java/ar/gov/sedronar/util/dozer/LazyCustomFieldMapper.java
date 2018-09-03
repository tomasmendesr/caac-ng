package ar.gov.sedronar.util.dozer;

import org.dozer.CustomFieldMapper;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;
import org.hibernate.collection.internal.PersistentSet;
/**
 *  Para evitar que hibernate consulte por las colecciones lazy cada vez que dozer hace el mapping.
 */
public class LazyCustomFieldMapper implements CustomFieldMapper 
{
    public boolean mapField(Object source, Object destination, Object sourceFieldValue, ClassMap classMap, FieldMap fieldMapping) 
    {       
        // Check if field is a Hibernate PersistentSet
        if (!(sourceFieldValue instanceof PersistentSet)) {
            // Allow dozer to map as normal
            return false;
        }

        // Check if field is already initialized
        if (((PersistentSet) sourceFieldValue).wasInitialized()) {
            // Allow dozer to map as normal
            return false;
        }

        // Set destination to null, and tell dozer that the field is mapped
        destination = null;
        return true;
    }   
}