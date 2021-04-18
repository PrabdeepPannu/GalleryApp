import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { CardsRow } from '../common/CardsRow/CardsRow'
import { CardModellingData } from '../fieldTypes'
import "./ExistingModelledData.css"


export const ExistingModelledData = () => {
  const [existingModels, setExistingModels] = useState([])
  useEffect(() => {
    const fetchData = async () => {
      const result = await axios("https://jsonplaceholder.typicode.com/posts")
      console.log(result.data);
      setExistingModels(result.data)
    }
    fetchData()
  }, [])
  return (
    <CardsRow headding="Existing modelled data">
      {existingModels.map(existingModel => <CardModellingData key={existingModel.id} data={existingModel}></CardModellingData>)}

    </CardsRow>
  )
}
