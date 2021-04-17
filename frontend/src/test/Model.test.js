import chai, {expect} from "chai";
import chaiEnzyme from "chai-enzyme";
import Model from "../model/Model"

describe("Model", () => {
    it("post and get Api", async () => {
        const metricsModel = new Model('metric');
        let metric;
        try {
            metric = await metricsModel.add({ difference: 5, data: 'test' });
        } catch (err) { console.log(err);}
        expect(metric.difference).to.equal(5);
        expect(metric.data).to.equal('test');
    });

    chai.use(chaiEnzyme());
})