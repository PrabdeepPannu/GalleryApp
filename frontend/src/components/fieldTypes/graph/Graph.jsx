import Highcharts from "highcharts/highstock";
import HighchartsReact from "highcharts-react-official";
var React = require("react");

const options = {
  title: {
    text: "My stock chart",
  },
  series: [
    {
      data: [1, 2, 1, 4, 3, 6, 7, 3, 8, 6, 9],
    },
  ],
};

const Graph = () => (
  <div>
    <HighchartsReact
      highcharts={Highcharts}
      constructorType={"stockChart"}
      options={options}
    />
  </div>
);

export default Graph;
