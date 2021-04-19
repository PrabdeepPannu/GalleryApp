var fs = require( "fs");

const faker = require( "faker");
const uuid = require('uuid');

let servicesData = [];
let modelDataString = [];
let metricsString = [];
let graphString = [];

const modelData = ['Target', 'Likes', 'Comments', 'tags', 'Posts', 'Trends'];


for (let j = 0; j < 36; j++) {
    const service = {id: uuid.v4(), name: faker.company.companyName()};
    servicesData.push(`( "${service.id}", "${service.name}", "service", "")`);
    for (let i = 0; i < modelData.length; i++) {
        const modelData = { id: uuid.v4(), name: faker.company.companyName() }
        modelDataString.push(`( "${modelData.id}", "${service.name}-${modelData.name}", "model", "test", "test", "", "", "${service.id}")`);
        for (let k = 0; k < 5; k++) {
            let metricId = uuid.v4();
            metricsString.push(`( "${metricId}", "${service.name}-${modelData}-Metric-${i}", "metric", 14, "${modelData.id}", "${service.id}")`);
            graphString.push(`( "${uuid.v4()}", 10000, "2020-01-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 20000, "2020-02-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 30000, "2020-03-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 40000, "2020-04-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 40000, "2020-05-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 30000, "2020-06-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 50000, "2020-07-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 30000, "2020-08-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 70000, "2020-09-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 80000, "2020-10-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 50000, "2020-11-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 30000, "2020-12-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 80000, "2021-01-01", "${metricId}")`);
            graphString.push(`( "${uuid.v4()}", 90000, "2021-02-01", "${metricId}")`);
        }
     }
}
const data = `
INSERT INTO service (id, name, type, icon_url) VALUES
${servicesData.join(",\n")}

INSERT INTO model (id, name, type, user_name, password, api, query, service_id) VALUES
${modelDataString.join(",\n")}
INSERT INTO model (id, name, type, difference, model_id, service_id) VALUES
${metricsString.join(",\n")}

INSERT INTO model (id, hit, date, metric_id) VALUES
${graphString.join(",\n")}`;
fs.writeFile( "dummy_data.sql", data, (err) => {
  if (err) console.log(err);
  console.log( "Successfully Written to File.");
});
