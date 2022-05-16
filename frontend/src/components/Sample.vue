<template>
  <el-card>
    <p>Data status:
      <span>{{ message }}</span>
    </p>
    <p>Please refresh if you need to reset the dataObject</p>
    <button type="button" v-on:click="testResult">Click to update chart data from localhost:8443.</button>
    <button type="button" v-on:click="logData">Log the data.</button>
    <apexchart width="500" type="bar" :options="dataObject.options" :series="dataObject.series"></apexchart>
  </el-card>
</template>

<script>
export default {
  name: 'Sample',
  data() {
    return {
      message: 'Not initialized. Raw data used.',
      dataObject: {
        options: {
          chart: {
            id: 'vuechart-example'
          }
          ,
          xaxis: {
            categories: [1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998]
          }
        }
        ,
        series: [{
          name: 'series-1',
          data: [30, 40, 45, 50, 49, 60, 70, 2]
        }]
      }
    }
  },
  updated() {
    this.testResults()
  }
  ,
  methods: {
    logData (){
      let component = this
      console.log(component.dataObject)
    }
    ,
    testResult() {
      let component = this
      this.message = 'Await synchronization'
      this.$axios
        .post('/sample')
        .then(response => {
          component.message = 'Response received.'
          console.log(response.data)
          if (response.status === 200) {
            // // this.$router.replace({path: '/helloworld'})
            // component.message = '??'
            component.dataObject = response.data
            component.message = 'Data updated from localhost:8443'
          }
          console.log(response.data.code)
        })
        .catch(failResponse => {
          component.message = 'Failed to get the response. Check whether the backend server has been initialized.'
        })
    }
  }
}
</script>

<style scoped>

</style>
