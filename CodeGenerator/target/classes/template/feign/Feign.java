package ${package_feign};
import com.pkx.code.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/****
 * @Author: https://blog.csdn.net/pkxwyf
 *****/
@FeignClient(name="${serviceName}")
@RequestMapping("/${table}")
public interface ${Table}Feign {

    /***
     * 分页+条件搜索${Table}表数据
     * @param ${table}
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) ${Table} ${table}, @PathVariable  int page, @PathVariable  int size);

    /***
     * 分页搜索${Table}表数据
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索${Table}表数据
     * @param ${table}
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<${Table}>> findList(@RequestBody(required = false) ${Table} ${table});

    /***
     * 根据ID删除${Table}表数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable ${keyType} id);

    /***
     * 修改${Table}表数据
     * @param ${table}
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody ${Table} ${table},@PathVariable ${keyType} id);

    /***
     * 新增${Table}表数据
     * @param ${table}
     * @return
     */
    @PostMapping
    Result add(@RequestBody ${Table} ${table});

    /***
     * 根据ID查询${Table}表数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<${Table}> findById(@PathVariable ${keyType} id);

    /***
     * 查询${Table}表全部数据
     * @return
     */
    @GetMapping
    Result<List<${Table}>> findAll();
}