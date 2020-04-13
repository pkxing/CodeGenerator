package ${package_service_impl};
import ${package_mapper}.${Table}Mapper;
import ${package_pojo}.${Table};
import ${package_service}.${Table}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author: PKXING
 * @Description:${Table}业务层接口实现类
 *****/
@Service
public class ${Table}ServiceImpl implements ${Table}Service {

    // 注入持久层对象
    @Autowired
    private ${Table}Mapper ${table}Mapper;


    /**
     * 条件+分页查询${Table}表数据
     * @param ${table} 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<${Table}> findPage(${Table} ${table}, int page, int size){
        // 分页
        PageHelper.startPage(page,size);
        // 搜索条件构建
        Example example = createExample(${table});
        // 执行搜索
        return new PageInfo<${Table}>(${table}Mapper.selectByExample(example));
    }

    /**
     * 分页查询${Table}表数据
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<${Table}> findPage(int page, int size){
        // 静态分页
        PageHelper.startPage(page,size);
        // 分页查询
        return new PageInfo<${Table}>(${table}Mapper.selectAll());
    }

    /**
     * 条件查询${Table}表数据
     * @param ${table}
     * @return
     */
    @Override
    public List<${Table}> findList(${Table} ${table}){
        // 构建查询条件
        Example example = createExample(${table});
        // 根据构建的条件查询数据
        return ${table}Mapper.selectByExample(example);
    }


    /**
     * ${Table}构建查询对象
     * @param ${table}
     * @return
     */
    public Example createExample(${Table} ${table}){
        Example example=new Example(${Table}.class);
        Example.Criteria criteria = example.createCriteria();
        if(${table}!=null){
            <#list models as md>
            //  ${md.desc}
            if(!StringUtils.isEmpty(${table}.get${md.upperName}())){
                <#if (md.name?contains("title") || md.name?contains("name"))>
                    criteria.andLike("${md.name}","%"+${table}.get${md.upperName}()+"%");
                <#else>
                    criteria.andEqualTo("${md.name}",${table}.get${md.upperName}());
                </#if>
            }
            </#list>
        }
        return example;
    }

    /**
     * 根据id删除${Table}表数据
     * @param id
     */
    @Override
    public void delete(${keyType} id){
        ${table}Mapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改${Table}表数据
     * @param ${table}
     */
    @Override
    public void update(${Table} ${table}){
        ${table}Mapper.updateByPrimaryKey(${table});
    }

    /**
     * 增加${Table}表数据
     * @param ${table}
     */
    @Override
    public void add(${Table} ${table}){
        ${table}Mapper.insert(${table});
    }

    /**
     * 根据ID查询${Table}表数据
     * @param id
     * @return
     */
    @Override
    public ${Table} findById(${keyType} id){
        return  ${table}Mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询${Table}表全部数据
     * @return
     */
    @Override
    public List<${Table}> findAll() {
        return ${table}Mapper.selectAll();
    }
}
