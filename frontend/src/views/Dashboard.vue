<template>
  <div class="dashboard p-4">
    <nav class="flex" aria-label="Breadcrumb">
      <ol class="inline-flex items-center space-x-1 md:space-x-3">
        <li class="inline-flex items-center">
          <a
              href="#"
              class="inline-flex items-center text-sm font-medium text-gray-700 hover:text-gray-900 dark:text-gray-400 dark:hover:text-white"
          >
            <svg
                class="mr-2 w-4 h-4"
                fill="currentColor"
                viewBox="0 0 20 20"
                xmlns="http://www.w3.org/2000/svg"
            >
              <path
                  d="M10.707 2.293a1 1 0 00-1.414 0l-7 7a1 1 0 001.414 1.414L4 10.414V17a1 1 0 001 1h2a1 1 0 001-1v-2a1 1 0 011-1h2a1 1 0 011 1v2a1 1 0 001 1h2a1 1 0 001-1v-6.586l.293.293a1 1 0 001.414-1.414l-7-7z"
              ></path>
            </svg>
            Dashboard
          </a>
        </li>
      </ol>
    </nav>
    <!-- end nav -->
    <div class="mt-5 w-full">
      <h1 class="text-2xl text-gray-900 dark:text-gray-200 font-medium">
        CS209A Data Visualization Project Dashboard - Dependency Analysis
      </h1>
    </div>
<!--    <br>-->

<!--    <div class="mt-5 w-full">-->
<!--      <h1 class="text-2xl text-gray-900 dark:text-gray-200 font-medium">-->
<!--        Dependency Analysis-->
<!--      </h1>-->
<!--    </div>-->
    <!-- grid wrapper card -->
<!--    <br>-->

    <div class="mt-5 w-full">
      <h1 class="text-2xl text-gray-900 dark:text-gray-200 font-medium">
        Dependency Usage Heat Map (My SQL as an example)
      </h1>
    </div>
<!--    <div class="wrapper-button w-full box-border mt-4">-->
<!--      <button-->
<!--          type="button" v-on:click="updateCountryDependency('spring'); changeColor(1)"-->
<!--          class="focus:outline-none text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800"-->
<!--      >-->
<!--        Show Spring-->
<!--      </button>-->
<!--      <button-->
<!--          type="button" v-on:click="updateCountryDependency('lombok'); changeColor(2)"-->
<!--          class="focus:outline-none text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"-->
<!--      >-->
<!--        Show Lombok-->
<!--      </button>-->
<!--      <button-->
<!--          type="button" v-on:click="updateCountryDependency('log4j'); changeColor(3)"-->
<!--          class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900"-->
<!--      >-->
<!--        Show log4j-->
<!--      </button>-->
<!--      <button-->
<!--          type="button" v-on:click="updateCountryDependency('mysql'); changeColor(4)"-->
<!--          class="focus:outline-none text-white bg-purple-700 hover:bg-purple-800 focus:ring-4 focus:ring-purple-300 font-medium rounded-lg text-sm px-5 py-2.5 mb-2 dark:bg-purple-600 dark:hover:bg-purple-700 dark:focus:ring-purple-900"-->
<!--      >-->
<!--        Show Mysql-->
<!--      </button>-->
<!--    </div>-->
    <div>
      <Map ref="MapCp" :high-color=mapCurrentColor.high_color :low-color=mapCurrentColor.low_color
           :country-data="countryData.data"/>
    </div>

    <div>
      <button v-on:click="updateCountryDependency('mysql')">Update</button>
    </div>

    <div>
      <button class="border-b border-blue-300 text-green-700" v-on:click="updateServerStatus">Update Server Status</button>
    </div>

<!--    <div class="mt-5 w-full">-->
<!--      <h1 class="text-2xl text-gray-900 dark:text-gray-200 font-medium">-->
<!--        Heat Map Test 2-->
<!--      </h1>-->
<!--    </div>-->

<!--    <div id="chartdiv" class="sample-map">-->
<!--    </div>-->

    <div
        class="wrapper-card grid lg:grid-cols-4 grid-cols-1 md:grid-cols-2 gap-2 mt-5"
    >
      <!-- card  -->
      <div
          class="card bg-white dark:bg-gray-800 w-full rounded-md p-5 shadow flex"
      >
        <div class="p-2 max-w-sm">
          <div
              class="bg-orange-200 rounded-full w-14 h-14 text-lg p-3 text-orange-600 mx-auto"
          >
            <span class="">
              <svg
                  xmlns="http://www.w3.org/2000/svg"
                  aria-hidden="true"
                  role="img"
                  width="30px"
                  height="30px"
                  preserveAspectRatio="xMidYMid meet"
                  viewBox="0 0 24 24"
              >
                <path
                    fill="currentColor"
                    d="M10 16V8a2 2 0 0 1 2-2h9V5c0-1.1-.9-2-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14c1.1 0 2-.9 2-2v-1h-9a2 2 0 0 1-2-2zm3-8c-.55 0-1 .45-1 1v6c0 .55.45 1 1 1h9V8h-9zm3 5.5c-.83 0-1.5-.67-1.5-1.5s.67-1.5 1.5-1.5s1.5.67 1.5 1.5s-.67 1.5-1.5 1.5z"
                />
              </svg>
            </span>
          </div>
        </div>

        <div class="block p-2 w-full">
          <p class="font-semibold text-gray-900 dark:text-gray-200 text-xl">
            {{ serverStatus.data.sampledEntries }}
          </p>
          <h2 class="font-normal text-gray-400 text-md mt-1">Sampled Entries</h2>
        </div>
      </div>
      <!-- end card -->

      <div
          class="card bg-white dark:bg-gray-800 w-full rounded-md p-5 shadow flex"
      >
        <div class="p-2 max-w-sm">
          <div
              class="bg-green-200 rounded-full w-14 h-14 text-lg p-3 text-green-600 mx-auto"
          >
            <span class="">
              <svg
                  xmlns="http://www.w3.org/2000/svg"
                  aria-hidden="true"
                  role="img"
                  width="30px"
                  height="30px"
                  preserveAspectRatio="xMidYMid meet"
                  viewBox="0 0 24 24"
              >
                <path
                    fill="currentColor"
                    d="M5 22h14a2 2 0 0 0 2-2V9a1 1 0 0 0-1-1h-3v-.777c0-2.609-1.903-4.945-4.5-5.198A5.005 5.005 0 0 0 7 7v1H4a1 1 0 0 0-1 1v11a2 2 0 0 0 2 2zm12-12v2h-2v-2h2zM9 7c0-1.654 1.346-3 3-3s3 1.346 3 3v1H9V7zm-2 3h2v2H7v-2z"
                />
              </svg>
            </span>
          </div>
        </div>

        <div class="block p-2 w-full">
          <p class="font-semibold text-gray-900 dark:text-gray-200 text-xl">
            {{serverStatus.data.requestCount}}
          </p>
          <h2 class="font-normal text-gray-400 text-md mt-1">Request Count</h2>
        </div>
      </div>
      <!-- end card -->
      <div
          class="card bg-white dark:bg-gray-800 w-full rounded-md p-5 shadow flex"
      >
        <div class="p-2 max-w-sm">
          <div
              class="bg-red-200 rounded-full w-14 h-14 text-lg p-3 text-red-600 mx-auto"
          >
            <span class="">
              <svg
                  xmlns="http://www.w3.org/2000/svg"
                  aria-hidden="true"
                  role="img"
                  width="30px"
                  height="30px"
                  preserveAspectRatio="xMidYMid meet"
                  viewBox="0 0 32 32"
              >
                <path
                    fill="none"
                    d="M8.007 24.93A4.996 4.996 0 0 1 13 20h6a4.996 4.996 0 0 1 4.993 4.93a11.94 11.94 0 0 1-15.986 0ZM20.5 12.5A4.5 4.5 0 1 1 16 8a4.5 4.5 0 0 1 4.5 4.5Z"
                />
                <path
                    fill="currentColor"
                    d="M26.749 24.93A13.99 13.99 0 1 0 2 16a13.899 13.899 0 0 0 3.251 8.93l-.02.017c.07.084.15.156.222.239c.09.103.187.2.28.3c.28.304.568.596.87.87c.092.084.187.162.28.242c.32.276.649.538.99.782c.044.03.084.069.128.1v-.012a13.901 13.901 0 0 0 16 0v.012c.044-.031.083-.07.128-.1c.34-.245.67-.506.99-.782c.093-.08.188-.159.28-.242c.302-.275.59-.566.87-.87c.093-.1.189-.197.28-.3c.071-.083.152-.155.222-.24ZM16 8a4.5 4.5 0 1 1-4.5 4.5A4.5 4.5 0 0 1 16 8ZM8.007 24.93A4.996 4.996 0 0 1 13 20h6a4.996 4.996 0 0 1 4.993 4.93a11.94 11.94 0 0 1-15.986 0Z"
                />
              </svg>
            </span>
          </div>
        </div>

        <div class="block p-2 w-full">
          <p class="font-semibold text-gray-900 dark:text-gray-200 text-xl">
            {{serverStatus.data.currentUpdateStatus}}
          </p>
          <h2 class="font-normal text-gray-400 text-md mt-1 ">
            Current Update Status
          </h2>
          <div>
            <button class="border-b border-blue-300" v-on:click="triggerServerUpdate">Update</button>
          </div>
        </div>
      </div>
      <!-- end card -->
      <div
          class="card bg-white dark:bg-gray-800 w-full rounded-md p-5 shadow flex"
      >
        <div class="p-2 max-w-sm">
          <div
              class="bg-purple-200 rounded-full w-14 h-14 text-lg p-3 text-purple-600 mx-auto"
          >
            <span class="">
              <svg
                  xmlns="http://www.w3.org/2000/svg"
                  aria-hidden="true"
                  role="img"
                  width="30px"
                  height="30px"
                  preserveAspectRatio="xMidYMid meet"
                  viewBox="0 0 16 16"
              >
                <g fill="currentColor">
                  <path d="M15 13v1H1.5l-.5-.5V0h1v13h13Z"/>
                  <path
                      d="M13 3.207L7.854 8.354h-.708L5.5 6.707l-3.646 3.647l-.708-.708l4-4h.708L7.5 7.293l5.146-5.147h.707l2 2l-.707.708L13 3.207Z"
                  />
                </g>
              </svg>
            </span>
          </div>
        </div>

        <div class="block p-2 w-full">
          <p class="font-semibold text-gray-900 dark:text-gray-200 text-xl">
            {{serverStatus.data.sampleSize}}
          </p>
          <h2 class="font-normal text-gray-400 text-md mt-1">Sample Size</h2>
        </div>
      </div>
      <!-- end card -->
    </div>
    <!-- end wrapper card -->

    <div class="mt-2 lg:flex block lg:gap-2">
      <div
          class="bg-white dark:bg-gray-800 p-5 w-full rounded-md box-border shadow"
      >
        <h2 class="font-bold text-lg text-gray-800 dark:text-gray-200">
          Dependency Usage
        </h2>
        <p class="text-gray-400 font-lexend font-normal">
          Usage statistic of <span id="selectedDependency">specific dependency</span>
        </p>
        <br/>
        <apexchart
            width="100%"
            height="380"
            type="bar"
            :options="optionsArea"
            :series="topUsedDependencyData.series"
            :sparkline="{
            enabled: true,
          }"
        ></apexchart>
        <div class="wrapper-button mt-3 float-left">
          <div class="block p-2">
            <div>
              <span class="t-blue-600">Year</span>
              <select
                  id="YearOption"
                  class="dark:bg-gray-800 dark:hover:bg-gray-700 border-gray-200 dark:border-gray-300 border max-w-lg px-4 py-3 block rounded-md text-gray-500 dark:text-gray-400"
                  v-on:change="handleDependencyFilter">
                <option value="Unselected" selected>Not selected</option>
                <option value=2022>2022</option>
                <option value=2021>2021</option>
                <option value=2020>2020</option>
                <option value=2019>2019</option>
                <option value=2018>2018</option>
                <option value=2017>2017</option>
                <option value=2016>2016</option>
                <option value=2015>2015</option>
                <option value=2014>2014</option>
                <option value=2013>2013</option>
                <option value=2012>2012</option>
                <option value=2011>2011</option>
                <option value=2010>2010</option>
                <option value=2009>2009</option>
                <option value=2008>2008</option>
              </select>
            </div>
          </div>
          <div class="wrapper-button mt-3 right-0">
            <div class="block p-2">
              <span>GroupId</span>
              <select
                  id="GroupOption"
                  class="dark:bg-gray-800 dark:hover:bg-gray-700 border-gray-200 dark:border-gray-300 border max-w-lg px-4 py-3 block rounded-md text-gray-500 dark:text-gray-400"
                  v-on:change="handleDependencyFilter">
                <option value="Unselected" selected>Not selected</option>
                <option value="org.springframework">org.springframework</option>
                <option value="org.projectlombok">org.projectlombok</option>
                <option value="log4j">log4j</option>
                <option value="mysql">mysql</option>
              </select>
            </div>
          </div>
          <button
              class="float-middle -mt-7 border-b border-blue-300 text-blue-500"
              v-on:click="updateTopUsedDependency"
          >
            Refresh
          </button>
          <br>
          <div>
            <button
                class="float-middle -mt-7 border-b border-green-600 text-green-600"
                v-on:click="updateTopUsedVersion"
            >
              TopUsed
            </button>
            <br>
            <button
                class="float-center -mt-7 border-b border-red-600 text-red-600"
                v-on:click="updateArtifactByGroupId"
            >
              updateArtifactByGroupId
            </button>
          </div>
        </div>
      </div>
    </div>


    <div
        class="mt-2 bg-white dark:bg-gray-800 p-5 w-full rounded-md box-border shadow"
    >
      <h2 class="font-bold text-lg text-gray-800 dark:text-gray-200">
        Latest Search Submissions
      </h2>
      <p class="text-gray-400 font-lexend font-normal">
        Latest search submissions to source websites.
      </p>
      <div class="wrapping-table mt-10">
        <table
            class="w-full text-sm text-left text-gray-500 dark:text-gray-400 lg:overflow-auto overflow-x-scroll"
        >
          <thead
              class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400"
          >
          <tr>
            <th scope="col" class="uppercase px-6 py-3">Search Query</th>
            <th scope="col" class="uppercase px-6 py-3">Date & Time</th>
            <th scope="col" class="uppercase px-6 py-3">Source Website</th>
            <th scope="col" class="uppercase px-6 py-3">Status</th>
          </tr>
          </thead>
          <tbody>
          <tr
              class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 odd:bg-white even:bg-gray-50"
              v-for="items in backendStatusData.tableSearchSubmissions.slice().reverse().slice(0,10)"
              :key="items.searchQuery"
          >
            <td class="px-6 py-4">
              {{ items.searchQuery }}
            </td>
            <td class="px-6 py-4">
              {{ items.date }}
            </td>
            <td class="px-6 py-4">
              {{ items.source }}
            </td>
            <td class="px-6 py-4">
                <span
                    class="text-green-800 bg-green-300 px-3 py-1 rounded-md"
                    v-if="items.statusQuery === 'completed'"
                >
                  {{ items.statusQuery }}
                </span>
              <span
                  class="text-purple-800 bg-purple-300 px-3 py-1 rounded-md"
                  v-else-if="items.statusQuery === 'progress'"
              >
                  {{ items.statusQuery }}
                </span>
              <span
                  class="text-red-800 bg-red-300 px-3 py-1 rounded-md"
                  v-else
              >
                  {{ items.statusQuery }}
                </span>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
      <div class="wrapper-button mt-3">
        <select
            name=""
            id=""
            class="dark:bg-gray-800 dark:hover:bg-gray-700 border-gray-200 dark:border-gray-300 border max-w-lg px-4 py-3 block rounded-md text-gray-500 dark:text-gray-400"
        >
        </select>
        <button
            class="uppercase float-right -mt-7 border-b border-green-700 text-green-700"
            v-on:click="updateBackendQueryStatus"
        >
          refresh status
        </button>
      </div>
    </div>
  </div>

  <!--  <script src="https://cdn.amcharts.com/lib/5/index.js"></script>-->
  <!--  <script src="https://cdn.amcharts.com/lib/5/map.js"></script>-->
  <!--  <script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>-->
</template>

<script>

// @ is an alias to /src
import {Icon} from "@iconify/vue";
import Map from 'vue-world-map';
import Button from "@/views/components/button";
import * as am5 from "@amcharts/amcharts5";
import * as am5map from "@amcharts/amcharts5/map"
import am5themes_Animated from '@amcharts/amcharts5/themes/Animated';

// import worldLowMap from

export default {
  name: "Dashboard",
  data() {
    return {
      serverStatus: {
        data: {
          sampledEntries: 0,
          requestCount: 0,
          currentUpdateStatus: "NOT INITIATED",
          sampleSize: 0
        }
      },
      backendStatusData: {
        tableSearchSubmissions: [
          {
            searchQuery: "Query test 1",
            date: "2022-5-05",
            source: "GitHub",
            statusQuery: "completed",
          },
          {
            searchQuery: "Query test 2",
            date: "2022-5-17",
            source: "Stack Overflow",
            statusQuery: "completed",
          },
          {
            searchQuery: "Query test 3",
            date: "2022-5-18",
            source: "GitHub",
            statusQuery: "progress",
          },
          {
            searchQuery: "Query test 4",
            date: "2022-5-20",
            source: "Stack Overflow",
            statusQuery: "cancelled",
          },
        ],

      }
      ,
      countryData: {
        data: {US: 100, CA: 120, RU: 4000}
      },
      mapCurrentColor: {
        high_color: '#E7042EFF',
        low_color: '#E38585FF'
      },
      Map_colors: {
        data: [
          {
            high_color: '#E7042EFF',
            low_color: '#ffffff'
          }, {//red
            high_color: '#E7042EFF',
            low_color: '#ffffff'
          },//blue
          {
            high_color: '#025ED9FF',
            low_color: '#ffffff'
          },
          {//green
            high_color: '#02D92DFF',
            low_color: "#ffffff"
          },
          {//purple
            high_color: '#6400C9FF',
            low_color: '#ffffff'
          }
        ]
      },
      topUsedDependencyData: {
        series: [{
          data: [{
            x: 'category A',
            y: 10
          }, {
            x: 'category B',
            y: 18
          }, {
            x: 'category C',
            y: 13
          }]
        }]
      },
      // chart data area
      optionsArea: {
        fontFamily: "sans-serif, sans-serif",
        stroke: {
          curve: "straight",
        },
        plotOptions: {
          bar: {
            horizontal: true
          }
        },
        markers: {
          size: 0,
        },
        fill: {
          type: "gradient",
          gradient: {
            shadeIntensity: 1,
            opacityFrom: 0.4,
            opacityTo: 1.0,
            stops: [0, 45, 100],
          },
        },
      },

      chart: {
        fontFamily: "sans-serif, sans-serif",
      },

      seriesArea: [
        {
          name: "Revenue",
          data: [30, 40, 45, 50, 49, 60, 70, 91],
        },
        {
          name: "Revenue (Previous period)",
          data: [20, 34, 45, 55, 79, 87, 90, 98],
        },
      ],
      optionsBar: {
        chart: {
          toolbar: {
            show: false,
          },
          zoom: {
            enabled: false,
          },
          sparkline: {
            enabled: true,
          },
        },
        legend: {
          show: false,
        },
        xaxis: {
          show: false,
        },
        yaxis: {
          show: false,
        },
        colors: ["#4f46e5", "#DC2626"],
        dataLabels: {
          enabled: false,
        },
        stroke: {
          curve: "straight",
        },
      },

      seriesBar: [
        {
          name: "Product 1",
          data: [30, 40, 45, 50, 49, 60, 70, 91],
        },
        {
          name: "Product 2",
          data: [20, 34, 45, 55, 79, 87, 90, 98],
        },
      ],
      optionsVisitor: {
        chart: {
          toolbar: {
            show: false,
          },
          zoom: {
            enabled: false,
          },
          sparkline: {
            enabled: true,
          },
        },
        legend: {
          show: false,
        },
        xaxis: {
          show: false,
        },
        yaxis: {
          show: false,
        },
        colors: ["#4f46e5"],
        dataLabels: {
          enabled: false,
        },
        fill: {
          type: "gradient",
          gradient: {
            shadeIntensity: 1,
            opacityFrom: 0.7,
            opacityTo: 0.9,
            stops: [0, 90, 100],
          },
        },
        stroke: {
          curve: "smooth",
        },
      },

      seriesVisitor: [
        {
          name: "Visitor ",
          data: [30, 40, 45, 50, 49, 60, 70, 91],
        },
      ],
      optionsDonut: {
        chart: {
          type: "donut",
        },
        legend: false,
        dataLabels: {
          enabled: false,
        },
        labels: ["admin", "SuperAdmin", "User", "Costumer"],
      },

      seriesDonut: [20, 15, 63, 83],
    };
    // end chart data line
  },
  components: {
    Button,
    Icon,
    Map
  },
  inject: ['axios']
  ,
  methods: {
    changeColor(targetColorNumber) {
      console.log('Change target color to' + targetColorNumber)
      let component = this

      this.mapCurrentColor.highColor = this.Map_colors.data[targetColorNumber - 1].high_color
      this.mapCurrentColor.lowColor = this.Map_colors.data[targetColorNumber - 1].low_color
    },
    onMouseEnterMapCountry(countryCode) {
      this.showMapOverlay = true
      // Update your data/property to be displayed on the overlay.
    },
    onMouseLeaveMapCountry() {
      this.showMapOverlay = false
    },
    onClickMapCountry(data) {
      console.log('Click Country', data)
    },
    updateCountryDependency(dependencyName) {
      let component = this
      this.axios //Automatically
          .get('/map/' + dependencyName)
          .then(successResponse => {
            console.log(successResponse.data)
            if (successResponse.status === 200) {
              component.countryData.data = successResponse.data
            }
          })
          .catch(failResponse => {
            console.log('Error on retrieving data.')
            console.log(failResponse);
          })
    },
    handleDependencyFilter() {
      const yearSelection = document.getElementById("YearOption");
      let year = yearSelection.options[yearSelection.selectedIndex].value;
      const groupIdSelection = document.getElementById("GroupOption");
      let group = groupIdSelection.options[groupIdSelection.selectedIndex].value;
      if (group === "Unselected") {
        group = null
      }
      if (year === "Unselected") {
        year = null
      }

      let component = this
      this.axios //Automatically
          .get("/data/top-used-dependencies?", {params: {"group": group, "year": year, "count": null}})
          .then(successResponse => {
            // console.log(successResponse.data)
            if (successResponse.status === 200) {
              //Modify data there
              console.log("Success")
              console.log(successResponse.data)
              console.log("End success response")
              component.topUsedDependencyData.series[0].data = successResponse.data
              console.log(component.topUsedDependencyData)

            }
          })
          .catch(failResponse => {
            console.log(0)
            console.log('Error on retrieving data.')
            console.log(failResponse);
          })
    },
    //Get the response from backend
    updateTopUsedDependency() {
      let component = this
      this.axios //Automatically
          .get('/data/top-used-dependencies')
          .then(successResponse => {
            console.log(successResponse.data)
            if (successResponse.status === 200) {
              //Modify data there
              component.topUsedDependencyData.series[0].data = successResponse.data
              // console.log(component.topUsedDependencyData)
              console.log("Successfully updated top used dependencies.")
            }
          })
          .catch(failResponse => {
            console.log('Error on retrieving data.')
            console.log(failResponse);
          })
    },
    updateTopUsedVersion() {
      let component = this
      this.axios //Automatically
          .get('/data/top-used-version')
          .then(successResponse => {
            console.log(successResponse.data)
            if (successResponse.status === 200) {

              //Modify data there
              component.topUsedDependencyData.series[0].data = successResponse.data
              console.log(component.topUsedDependencyData)
            }
          })
          .catch(failResponse => {
            console.log('Error on retrieving data.')
            console.log(failResponse);
          })
    },
    updateArtifactByGroupId() {

    },
    updateBackendQueryStatus() {
      let component = this
      this.axios //Automatically
          .get('/status/query-status')
          .then(successResponse => {
            console.log(successResponse.data)
            if (successResponse.status === 200) {

              //Modify data there
              component.backendStatusData.tableSearchSubmissions = successResponse.data
              console.log(component.backendStatusData.tableSearchSubmissions)
            }
          })
          .catch(failResponse => {
            console.log('Error on retrieving data.')
            console.log(failResponse);
          })
    },
    updateServerStatus() {
      let component = this
      this.axios //Automatically
          .get('/status/server-status')
          .then(successResponse => {
            console.log(successResponse.data)
            if (successResponse.status === 200) {

              //Modify data there
              component.serverStatus.data = successResponse.data
              console.log(component.serverStatus.data)
            }
          })
          .catch(failResponse => {
            console.log('Error on retrieving data.')
            console.log(failResponse);
          })
    },
    triggerServerUpdate() {
      let component = this
      this.axios //Automatically
          .get('/local/update-all')
          .then(successResponse => {
            console.log(successResponse.data)
            if (successResponse.status === 200) {
              //Modify data there
              console.log("Success triggered.")
            }
          })
          .catch(failResponse => {
            console.log('Error on sending the request.')
            console.log(failResponse);
          })
    }


  },
  mounted: function () {
    this.updateTopUsedDependency()
    this.updateCountryDependency("mysql")
    this.updateServerStatus()
  },
};
</script>

<style scoped>
/*.sample-map {*/
/*  width: 100%;*/
/*  height: 700px;*/
/*}*/
</style>
