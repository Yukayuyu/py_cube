package simpleBatis;
import simpleBatis.Mapper.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

//import myBatis03.Mapper.UserMapper;

public class Entity01UserDAO {
    public final static SqlSessionFactory theFactory = MySessionFactory.buildTheFactory();

    public Entity01User getUserByID(String id) {
        Entity01User result = null;
        try (SqlSession aSession = theFactory.openSession()) {
//        	  result = aSession.selectOne(
//        			    "myBatis03.Mapper.UserMapper.getUserByID", 03);
//        			}
        	UserMapper mapper = aSession.getMapper(UserMapper.class);
            result = mapper.getUserByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // ! aSession.close();
        }
        return result;
    } 
}
