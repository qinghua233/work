public class Catalog {
    public String order_catalog(){
        String sql="select* from order_management_system";
        return sql;
    }

    public String Commodity_catalog(){
        String sql="select* from Commodity;";
        return sql;
    }
}
