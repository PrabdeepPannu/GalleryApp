import React, { useEffect, useState } from "react";
import { CardsRow } from "../common/CardsRow/CardsRow";
import CardService from "../fieldTypes/cardServices/CardServices";
import "./RecommendedServices.css";

import Model from "../../model/Model";

export const RecommendedServices = () => {
  const [services, setServices] = useState([]);
  useEffect(() => {
    const fetchData = async () => {
      const service = new Model("service");
      const result = await service.list();
      console.log(result);
      setServices(result);
    };
    fetchData();
  }, []);
  return (
    <CardsRow headding="Recommended services">
      {services.map((service) => (
        <CardService key={service.id} data={service}></CardService>
      ))}
    </CardsRow>
  );
};
