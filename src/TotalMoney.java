public class TotalMoney {
    public String totalMoney(){
     String sql="select sum(TotalPrice) as TotalMoney from order_management_system;";
     return sql;
    }
}
