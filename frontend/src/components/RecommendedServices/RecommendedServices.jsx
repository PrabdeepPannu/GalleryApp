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
      const result = await service.list();
      setServices(result);
    };
    fetchData();
  }, []);
  return (
    <CardsRow headding="Recommended services" name="Services">
      {services.map((service) => (
        <CardServics key={service.id} data={service}></CardServics>
      ))}
    </CardsRow>
  );
};
