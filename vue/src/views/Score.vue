<template>
  <div>
    <div class="card" style="margin-bottom:5px">
      <el-input v-model="query.studentId" clearable placeholder="学号或学生ID" @clear="filter" style="width:260px;margin-right:5px"/>
      <el-input v-model="query.courseId" clearable placeholder="课程ID" @clear="filter" style="width:260px;margin-right:5px"/>
      <el-button type="primary" @click="filter">查询</el-button>
      <el-button @click="reset">重置</el-button>
    </div>
    <div class="card" style="margin-bottom:5px">
      <el-button type="primary" @click="handleAdd">新增</el-button>
      <el-button type="danger" @click="deleteBatch">批量删除</el-button>
    </div>
    <div class="card" style="margin-bottom:5px">
      <el-table :data="pageData" @selection-change="onSelect" style="width:100%" :header-cell-style="{ background:'#eaf4ff', color:'#333' }">
        <el-table-column type="selection" width="55"/>
        <el-table-column prop="studentId" label="学生ID"/>
        <el-table-column prop="courseId" label="课程ID"/>
        <el-table-column prop="score" label="成绩"/>
        <el-table-column label="操作" width="120">
          <template #default="{row}">
            <el-button type="primary" icon="Edit" circle @click="handleEdit(row)"/>
            <el-button type="danger" icon="Delete" circle @click="del(row.id)"/>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="card">
      <el-pagination v-model:current-page="pageNum" v-model:page-size="pageSize"
                     :total="filtered.length" :page-sizes="[5,10,20]" layout="total, sizes, prev, pager, next, jumper"/>
    </div>
    <el-dialog title="成绩信息" v-model="formVisible" width="30%" destroy-on-close>
      <el-form ref="formRef" :model="form" :rules="rules" label-width="80px" style="padding:20px">
        <el-form-item label="学生ID" prop="studentId">
          <el-select v-model="form.studentId" placeholder="请选择">
            <el-option v-for="s in students" :key="s.id" :label="s.studentNo" :value="s.id"/>
          </el-select>
        </el-form-item>
        <el-form-item label="课程ID" prop="courseId">
          <el-select v-model="form.courseId" placeholder="请选择">
            <el-option v-for="c in courses" :key="c.id" :label="c.name" :value="c.id"/>
          </el-select>
        </el-form-item>
        <el-form-item label="成绩" prop="score">
          <el-input-number v-model="form.score" :min="0" :max="100" :step="0.01"/>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="formVisible=false">取消</el-button>
        <el-button type="primary" @click="save">保存</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, reactive, computed, onMounted } from 'vue'
import request from '@/utils/request'
import { ElMessage, ElMessageBox } from 'element-plus'

const all = ref([])
const filtered = ref([])
const students = ref([])
const courses = ref([])
const pageNum = ref(1), pageSize = ref(5)
const query = reactive({ studentId:'',courseId:'' })
const pageData = computed(() => filtered.value.slice((pageNum.value-1)*pageSize.value,(pageNum.value-1)*pageSize.value+pageSize.value))
const formVisible=ref(false), formRef=ref(), form=reactive({})
const rules = {
  studentId:[{required:true,message:'请选择学生',trigger:'change'}],
  courseId:[{required:true,message:'请选择课程',trigger:'change'}],
  score:[{required:true,message:'请输入成绩',trigger:'blur'}]
}
const selected = ref([])

function load(){
  request.get('/score').then(res=>{
    if(res.code===20000){ all.value=res.data; filtered.value=res.data }
  })
  request.get('/student').then(res=>{ if(res.code===20000) students.value=res.data })
  request.get('/course').then(res=>{ if(res.code===20000) courses.value=res.data })
}

function filter(){
  filtered.value=all.value.filter(i =>{
    return (query.studentId?i.studentId== query.studentId:true)
        &&(query.courseId?i.courseId== query.courseId:true)
  })
  pageNum.value=1
}

function reset(){ query.studentId=''; query.courseId=''; filter() }

function handleAdd(){ Object.assign(form,{}); formVisible.value=true }
function handleEdit(row){ Object.assign(form,row); formVisible.value=true }

function save(){
  formRef.value.validate(valid=>{
    if(!valid)return
    const method = form.id?'put':'post'
    request[method]('/score', form).then(res=>{
      res.code===20000?(ElMessage.success('保存成功'), load(), formVisible.value=false):ElMessage.error(res.message)
    })
  })
}

function del(id){
  ElMessageBox.confirm('删除该成绩？','提示',{type:'warning'}).then(()=>{
    request.delete(`/score/${id}`).then(res=>{
      res.code===20000?(ElMessage.success('删除成功'), load()):ElMessage.error(res.message)
    })
  })
}

function onSelect(rows){selected.value=rows}
function deleteBatch(){
  if(!selected.value.length) return ElMessage.warning('未选择')
  ElMessageBox.confirm('确定批量删除？','提示',{type:'warning'}).then(()=>{
    const ids = selected.value.map(i=>i.id)
    request.post('/score/batchDelete', ids).then(res=>{
      res.code===20000?(ElMessage.success('删除成功'), load()):ElMessage.error(res.message)
    })
  })
}

onMounted(load)
</script>
