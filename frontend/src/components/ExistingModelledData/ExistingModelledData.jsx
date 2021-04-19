import React, { useEffect, useState } from "react";
import { CardsRow } from "../common/CardsRow/CardsRow";
import { CardModellingData } from "../fieldTypes";
import "./ExistingModelledData.css";

import Model from "../../model/Model";

export const ExistingModelledData = () => {
  const [existingModels, setExistingModels] = useState([]);
  useEffect(() => {
    const fetchData = async () => {
      const model = new Model("model");
      const result = await model.list();
      setExistingModels(result);
    };
    fetchData();
  }, []);
  return (
    <CardsRow headding="Existing modelled data">
      {existingModels.map((existingModel) => (
        <CardModellingData
          key={existingModel.id}
          data={existingModel}
        ></CardModellingData>
      ))}
    </CardsRow>
  );
};
