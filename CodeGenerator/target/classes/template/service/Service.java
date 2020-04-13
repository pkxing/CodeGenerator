package ${package_service};
import ${package_pojo}.${Table};
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author: https://blog.csdn.net/pkxwyf
 * @Description:${Table}业务层接口
 *****/
public interface ${Table}Service {

    /***
     * 多条件分页查询${Table}表数据
     * @param ${table}
     * @param page
     * @param size
     * @return
     */
    PageInfo<${Table}> findPage(${Table} ${table}, int page, int size);

    /***
     * 分页查询${Table}表数据
     * @param page
     * @param size
     * @return
     */
    PageInfo<${Table}> findPage(int page, int size);

    /***
     * 多条件搜索${Table}表数据
     * @param ${table}
     * @return
     */
    List<${Table}> findList(${Table} ${table});

    /***
     * 根据id删除${Table}表数据
     * @param id
     */
    void delete(${keyType} id);

    /***
     * 根据条件修改${Table}表数据
     * @param ${table}
     */
    void update(${Table} ${table});

    /***
     * 新增${Table}表数据
     * @param ${table}
     */
    void add(${Table} ${table});

    /**
     * 根据ID查询${Table}表数据
     * @param id
     * @return
     */
     ${Table} findById(${keyType} id);

    /***
     * 查询所有${Table}表数据
     * @return
     */
    List<${Table}> findAll();
}
