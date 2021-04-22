import React, { useEffect, useState } from "react";
import { CardsRow } from "../common";
import { CardServics } from "../fieldTypes";
import "./RecommendedServices.css";

import Model from "../../model/Model";

export const RecommendedServices = () => {
  const [services, setServices] = useState([]);
  useEffect(() => {
    const fetchData = async () => {
      const service = new Model("service");
      const result = await service.getRecommendedData();
      setServices(result);
    };
    fetchData();
  }, []);

  const handelMoreButton = async (e) => {
    const service = new Model("service");
    const result = await service.list();
    setServices(result);
  };

  const handelLessButton = async () => {
    const metric = new Model("service");
    const result = await metric.getRecommendedData();
    setServices(result);
  };

  return (
    <CardsRow
      headding="Recommended services"
      name="Services"
      onMoreClick={handelMoreButton.bind(this)}
      onLessClick={handelLessButton.bind(this)}
    >
      {services.map((service) => (
        <CardServics key={service.id} data={service}></CardServics>
      ))}
    </CardsRow>
  );
};
