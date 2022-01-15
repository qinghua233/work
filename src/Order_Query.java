public class Order_Query {
    public String order_query(int OrderNo){
        String sql="select* from order_management_system where OrderNO="+OrderNo+";";
        return sql;
    }
}
