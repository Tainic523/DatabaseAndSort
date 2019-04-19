package model.Mybaits;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SelectUserById {
    public static void main(String[] args)throws Exception{
        InputStream in= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        int id=100;
        Employees employees=session.selectOne("model.Mybaits.Employees.findUserById", id);
        System.out.println("name: "+employees.getLast()+" "+employees.getFirst()+" age : "+ employees.getAge()+" id: "+ employees.getId());
        session.close();

    }
}
