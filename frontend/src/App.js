import { Header } from './components/common';
import './App.css';

import React from 'react'
import { RecommendedMetrics } from './components/RecommendedMetrics/RecomendedMetrics';
import { RecommendedServices } from './components/RecommendedServices/RecommendedServices';
import { ExistingModelledData } from './components/ExistingModelledData/ExistingModelledData';

export const App = () => {
  return (
    <div className="App">
      <Header />
      <RecommendedMetrics></RecommendedMetrics>
      <RecommendedServices></RecommendedServices>
      <ExistingModelledData></ExistingModelledData>
    </div>
  )
}

export default App;
