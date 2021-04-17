import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { CardsRow } from '../common/CardsRow/CardsRow'
import CardService from '../fieldTypes/cardServices/CardServices'
import "./RecommendedServices.css"


export const RecommendedServices = () => {
  const [services, setServices] = useState([])
  useEffect(() => {
    const fetchData = async () => {
      const result = await axios("https://reqres.in/api/users")
      console.log(result.data.data)
      setServices(result.data.data)
    }
    fetchData()
  }, [])
  return (
    <CardsRow headding="Recommended services">
      {services.map(service => <CardService key={service.id} data={service}></CardService>)}

    </CardsRow>
  )
}
