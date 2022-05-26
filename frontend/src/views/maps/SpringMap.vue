<template>
  <div className="dependencymap p-4">

    <nav className="flex" aria-label="Breadcrumb">
      <ol className="inline-flex items-center space-x-1 md:space-x-3">
        <li className="inline-flex items-center">
          <a
              href="#"
              className="inline-flex items-center text-sm font-medium text-gray-700 hover:text-gray-900 dark:text-gray-400 dark:hover:text-white"
          >
            <svg
                className="mr-2 w-4 h-4"
                fill="currentColor"
                viewBox="0 0 20 20"
                xmlns="http://www.w3.org/2000/svg"
            >
              <path
                  d="M10.707 2.293a1 1 0 00-1.414 0l-7 7a1 1 0 001.414 1.414L4 10.414V17a1 1 0 001 1h2a1 1 0 001-1v-2a1 1 0 011-1h2a1 1 0 011 1v2a1 1 0 001 1h2a1 1 0 001-1v-6.586l.293.293a1 1 0 001.414-1.414l-7-7z"
              ></path>
            </svg>
            DependencyMap
          </a>
        </li>
      </ol>
    </nav>

    <div className="mt-5 w-full">
      <h1 className="text-2xl text-gray-900 dark:text-gray-200 font-medium">
        Dependency Map: Spring
      </h1>
    </div>

    <div className="sample-map" ref="chartdiv"></div>
    <button v-on:click="load">Test Update</button>

  </div>
</template>

<script>
import Button from "@/views/components/button";
import {Icon} from "@iconify/vue/dist/iconify";
import Map from "vue-world-map";
import * as am5 from "@amcharts/amcharts5";
import * as am5map from "@amcharts/amcharts5/map";
import am5themes_Animated from '@amcharts/amcharts5/themes/Animated';
import am5geodata_usaLow from "@amcharts/amcharts5-geodata/usaLow";
import am5geodata_worldLow from "@amcharts/amcharts5-geodata/worldLow";
import * as am5xy from "@amcharts/amcharts5/xy";

let chart
let heatLegend
let polygonSeries
let component
let countryData = {
  data: [
    {id: "US", value: 100},
    {id: "CN", value: 100}
  ]
}

const minColor = am5.color(0xd9ead3)
const maxColor = am5.color(0x26c96d)

export default {
  name: "SpringMap",

  components: {
    Button,
    Icon,
    Map
  },
  data() {
    return {
      dataFetched: false
    }
  },
  inject: ['axios']
  ,
  methods: {
    sleep(ms) {
      return new Promise(resolve => setTimeout(resolve, ms));
    },
    loadCountryData() {
      this.axios
          .get('/map/springImpl')
          .then(successResponse => {
            if (successResponse.status === 200) {

              console.log("Received: ok")
              console.log("success response")
              //Modify data there
              countryData.data = successResponse.data
              console.log(countryData.data)
              console.log("Ok. set")
            }
          })
          .catch(failResponse => {
            console.log('Error on retrieving data.')
            console.log(failResponse);
          }).then(function () {
        component.load()
        console.log("loaded.")
      })
    },
    load() {
      console.log("Ok. Loaded initials.")
      console.log(countryData.data)
      polygonSeries = am5map.MapPolygonSeries.new(this.root, {
        geoJSON: am5geodata_worldLow,
        valueField: "value",
        calculateAggregates: true
      });

      polygonSeries.mapPolygons.template.setAll({
        tooltipText: "{name}: {value}"
      });

      // Define heatRules
      //todo: modify this
      polygonSeries.set("heatRules", [{
        target: polygonSeries.mapPolygons.template,
        dataField: "value",
        min: minColor,
        max: maxColor,
        key: "fill"
      }]);

      polygonSeries.mapPolygons.template.events.on("pointerover", function (ev) {
        heatLegend.showValue(ev.target.dataItem.get("value"));
      });

      polygonSeries.events.on("datavalidated", function () {
        heatLegend.set("startValue", polygonSeries.getPrivate("valueLow"));
        heatLegend.set("endValue", polygonSeries.getPrivate("valueHigh"));
      });
      polygonSeries.data.setAll(countryData.data)
      chart.series.push(polygonSeries)
    },

    initMap() {

      let root = am5.Root.new(this.$refs.chartdiv);

      root.setThemes([am5themes_Animated.new(root)]);

      //current chart
      chart = root.container.children.push(
          am5map.MapChart.new(root, {
            panX: "rotateX",
            panY: "none",
            projection: am5map.geoEqualEarth(),
            layout: root.horizontalLayout
          })
      )
      // chart.set("zoomControl", am5map.ZoomControl.new(root, {}));


      heatLegend = chart.children.push(am5.HeatLegend.new(root, {
        orientation: "vertical",
        startColor: minColor,
        endColor: maxColor,
        startText: "Lowest",
        endText: "Highest",
        stepCount: 5
      }));

      heatLegend.startLabel.setAll({
        fontSize: 12,
        fill: heatLegend.get("startColor")
      });

      heatLegend.endLabel.setAll({
        fontSize: 12,
        fill: heatLegend.get("endColor")
      });

      this.root = root; //Maybe used to refresh contents
    }
  },

  mounted() {
    component = this
    this.loadCountryData()
    this.initMap()
    // this.load()
  },

  beforeDestroy() {
    if (this.root) {
      this.root.dispose();
    }
  }
}
</script>

<style scoped>
.sample-map {
  width: 100%;
  height: 600px;
}
</style>