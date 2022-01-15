import java.sql.*;
import java.util.Scanner;
public class TestSystem2 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        System.out.println("输入功能代码： 1.创造订单 2.删除订单 3.查询订单 4.修改订单 5.进货 6.订单总价 7.订单目录 8.商品目录 9.退出系统");
        int function=0;
        try {
            conn=Tool.getConnection();stmt=conn.createStatement();
            while(function!=9){
                function=s.nextInt();
                if(function==1){double price=0.0;int beforenum=0;
                New_Order new_order=new New_Order();
                conn.setAutoCommit(false);
                System.out.print("name:");
                String name=s.next();
                System.out.print("cno:");
                int Cno=s.nextInt();
                System.out.print("num:");
                int num=s.nextInt();
                String sql1=new_order.Price(Cno);rs=stmt.executeQuery(sql1);
                if(rs.next()){price=rs.getDouble("ComPrice");rs.close();}double totalprice=price*num;
                String sql2=new_order.num(Cno);rs=stmt.executeQuery(sql2);
                if(rs.next()){beforenum=rs.getInt("ComNum");rs.close();}
                String sql3=new_order.New_Order(name,Cno,num,totalprice);int count=stmt.executeUpdate(sql3);
                String sql4=new_order.update(Cno,beforenum,num);int count2=stmt.executeUpdate(sql4);
                if(count2>0&&count>0){ System.out.println("success,Continue to use the system or exit");
                conn.commit();}}
            else if(function==2){int Cno=0;int num=0;int beforenum=0;
                Order_delete order_delete=new Order_delete();
                conn.setAutoCommit(false);
                System.out.print("OederNO:");int OrderNo=s.nextInt();
                String sql1=order_delete.Cno(OrderNo);rs=stmt.executeQuery(sql1);
                if(rs.next()){Cno=rs.getInt("CommodityNo");rs.close();}
                String sql2=order_delete.num(OrderNo);rs=stmt.executeQuery(sql2);
                if(rs.next()){num=rs.getInt("Commoditynum");rs.close();}
                String sql3=order_delete.beforenum(Cno);rs=stmt.executeQuery(sql3);
                if(rs.next()){beforenum=rs.getInt("ComNum");rs.close();}
                String sql4=order_delete.order_delete(OrderNo);int count1=stmt.executeUpdate(sql4);
                String sql5=order_delete.update(Cno,num,beforenum);int count2=stmt.executeUpdate(sql5);
                if(count2>0&&count1>0) {System.out.println("success,Continue to use the system or exit");
                conn.commit();}}
            else if(function==3){
                System.out.print("OederNO:");int OrderNo=s.nextInt();
                Order_Query order_query=new Order_Query();
                String sql1=order_query.order_query(OrderNo);rs=stmt.executeQuery(sql1);
                if (rs.next()){
                    System.out.println("OrderNO:"+rs.getInt("OrderNO")+"    Customer:"+ rs.getString("Customer")+
                            "   CommodityNo:"+ rs.getInt("CommodityNo") +"  Commoditynum:"+rs.getInt("Commoditynum")
                            +"  TotalPrice:"+rs.getDouble("TotalPrice")+"   Createtime:"+rs.getString("Createtime"));
                    System.out.println("success,Continue to use the system or exit"); }}
            else if(function==4){int Cno=0;int num=0;int beforenum=0;double price=0.0;int Newbeforenum=0;int nNum=0;
                conn.setAutoCommit(false);
                System.out.print("OederNO:");
                int OrderNo=s.nextInt();
                System.out.print("Newcno:");
                int NewCno=s.nextInt();
                System.out.print("Newnum:");
                int Newnum=s.nextInt();
                Order_Change order_change=new Order_Change();
                String sql1=order_change.Cno(OrderNo);rs=stmt.executeQuery(sql1);
                if(rs.next()){Cno=rs.getInt("CommodityNo");rs.close();}
                String sql2=order_change.num(OrderNo);rs=stmt.executeQuery(sql2);
                if(rs.next()){nNum=rs.getInt("Commoditynum");rs.close();}
                String sql3=order_change.beforenum(Cno);rs=stmt.executeQuery(sql3);
                if(rs.next()){beforenum=rs.getInt("ComNum");rs.close();}
                String sql=order_change.beforenum(NewCno);rs=stmt.executeQuery(sql);
                if(rs.next()){Newbeforenum=rs.getInt("ComNum");rs.close();}
                String sql4=order_change.Price(NewCno);rs=stmt.executeQuery(sql4);
                if(rs.next()){price=rs.getDouble("ComPrice");rs.close();}double totalprice=price*Newnum;
                String sql5=order_change.update1(Cno,nNum,beforenum);int count1=stmt.executeUpdate(sql5);
                String sql6=order_change.update3(NewCno,Newbeforenum,Newnum);int count2=stmt.executeUpdate(sql6);
                String sql7=order_change.update2(OrderNo,NewCno,Newnum,totalprice);int count3=stmt.executeUpdate(sql7);
                if(count1>0&&count2>0&&count3>0){
                    System.out.println("success,Continue to use the system or exit");conn.commit();}}
            else if(function==5){stock_with_goods stock_with_goods=new stock_with_goods();
                System.out.println("输入功能代码： 1.进新货  2.补旧货 ");
                int function2 = s.nextInt();
                if(function2==1){
                    System.out.print("Cname:");
                    String Cname=s.next();
                    System.out.print("Cprice:");
                    double Cprice=s.nextDouble();
                    System.out.print("Newnum:");
                    int Cnum=s.nextInt();
                    String sql1=stock_with_goods.newstock_with_goods(Cname,Cprice,Cnum);int count1=stmt.executeUpdate(sql1);
                    if (count1>0){
                        System.out.println("success,Continue to use the system or exit");
                    }}
                else if(function2==2){int beforenum=0;
                    System.out.print("Cno:");
                    int Cno=s.nextInt();
                    System.out.print("Addnum:");
                    int addnum=s.nextInt();
                    String sql1=stock_with_goods.beforenum(Cno);rs=stmt.executeQuery(sql1);
                    if(rs.next()){beforenum=rs.getInt("ComNum");}
                    String sql2=stock_with_goods.oldstock_with_goods(Cno,beforenum,addnum);int count2=stmt.executeUpdate(sql2);
                    if (count2>0){
                        System.out.println("success,Continue to use the system or exit");
                    }
                }}
                else if(function==6){
                    TotalMoney totalMoney=new TotalMoney();
                    String sql=totalMoney.totalMoney();
                    rs=stmt.executeQuery(sql);
                    if(rs.next()){
                        System.out.println("TotalMoney:"+rs.getInt("TotalMoney"));}}
                else if (function==7||function==8){
                    String sql="";
                    Catalog catalog=new Catalog();
                    if(function==7){
                      sql=catalog.order_catalog();
                      rs=stmt.executeQuery(sql);
                        while(rs.next()){
                            System.out.println("OrderNO:"+rs.getInt("OrderNO")+"    Customer:"+ rs.getString("Customer")+
                                    "   CommodityNo:"+ rs.getInt("CommodityNo") +"  Commoditynum:"+rs.getInt("Commoditynum")
                                    +"  TotalPrice:"+rs.getDouble("TotalPrice")+"   Createtime:"+rs.getString("Createtime")
                                    );
                        }
                    }else if(function==8){sql=catalog.Commodity_catalog();
                        sql=catalog.Commodity_catalog();
                        rs=stmt.executeQuery(sql);
                        while(rs.next()){
                            System.out.println("CommodityNo:"+rs.getInt("CommodityNo")+"    ComName:"+ rs.getString("ComName")+"    ComPrice:"+rs.getDouble("ComPrice")+
                                    "   ComNum:"+rs.getInt("ComNum"));
                        }
                    }

                    System.out.println("success,Continue to use the system or exit");
                }
                else if(function==9){
                System.out.println("Exit successfully!");
                    try {
                        Thread.sleep(1000*2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;}}

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Tool.close(conn,stmt,rs);
        }
    }
}
