import React, { useEffect, useState } from "react";
import { CardsRow } from "../common";
import { CardModellingData } from "../fieldTypes";
import "./ExistingModelledData.css";

import Model from "../../model/Model";

export const ExistingModelledData = () => {
  const [existingModels, setExistingModels] = useState([]);
  useEffect(() => {
    const fetchData = async () => {
      const model = new Model("model");
      const result = await model.getRecommendedData();
      setExistingModels(result);
    };
    fetchData();
  }, []);

  const handelMoreButton = async (e) => {
    const model = new Model("model");
    const result = await model.list();
    setExistingModels(result);
  };

  const handelLessButton = async () => {
    const model = new Model("model");
    const result = await model.getRecommendedData();
    setExistingModels(result);
  };

  return (
    <CardsRow
      headding="Existing modelled data"
      name="Modelled data"
      onMoreClick={handelMoreButton.bind(this)}
      onLessClick={handelLessButton.bind(this)}
    >
      {existingModels.map((existingModel) => (
        <CardModellingData
          key={existingModel.id}
          data={existingModel}
        ></CardModellingData>
      ))}
    </CardsRow>
  );
};
