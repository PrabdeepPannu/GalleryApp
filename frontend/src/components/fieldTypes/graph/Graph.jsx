import Highcharts from "highcharts/highstock";
import HighchartsReact from "highcharts-react-official";
var React = require("react");

const Graph = ({ data, height }) => {
  const options = {
    xAxis: {
      visible: false,
    },
    tooltip: {
      enabled: false,
    },
    yAxis: {
      visible: false,
    },
    plotOptions: {
      visible: false,
    },
    credits: {
      visible: false,
    },
    series: [
      {
        data: data,
      },
    ],
    navigator: {
      enabled: false,
    },
    scrollbar: {
      enabled: false,
    },
    rangeSelector: {
      enabled: false,
    },
    chart: {
      type: "area",
      height,
    },
    markers: {
      enabled: false,
    }
  };
  return (
    <div>
      <HighchartsReact
        highcharts={Highcharts}
        constructorType={"stockChart"}
        options={options}
      />
    </div>
  );
};

export default Graph;
