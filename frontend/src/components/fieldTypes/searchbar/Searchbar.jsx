import React, { useState, useEffect, useRef } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./Searchbar.css";
import { api } from "../../../options.global";
import axios from "axios";

const SeachCard = ({ name, type }) => {
  const typeText = type ? type.charAt(0).toUpperCase() + type.slice(1) : "";
  const cardRef = useRef();
  return (
    <li
      class="list-group-item d-flex justify-content-between align-items-center"
      ref={cardRef}
    >
      {name}
      <span class="badge badge-pill">{typeText}</span>
    </li>
  );
};

const FilterButton = ({ onClick, name }) => {
  return (
    <button
      id="filterButton"
      type="button"
      className="btn btn-outline-primary ml-2 mt-2 mr-2"
      onClick={onClick}
    >
      {name}
    </button>
  );
};

function SearchBar() {
  const [searchText, setSearchText] = useState("");
  const searchCardContainer = useRef();

  const [state, setState] = useState({
    options: [],
    open: false,
  });

  const handelSearchButtonEvent = async (e) => {
    const result = await axios.get(`${api}/search/${searchText}`);
    setState((prevState) => {
      return { ...prevState, ...{ options: result.data, open: true } };
    });
  };

  const handelSearchMetricButton = async (e) => {
    const result = await axios.get(`${api}/search/metric/${searchText}`);
    setState((prevState) => {
      return { ...prevState, ...{ options: result.data, open: true } };
    });
  };

  const handelSearchServiceButton = async (e) => {
    const result = await axios.get(`${api}/search/service/${searchText}`);
    setState((prevState) => {
      return { ...prevState, ...{ options: result.data, open: true } };
    });
  };

  const handelSearchModelledButton = async (e) => {
    console.log(searchText);
    const result = await axios.get(`${api}/search/model/${searchText}`);
    setState((prevState) => {
      return { ...prevState, ...{ options: result.data, open: true } };
    });
  };

  const handleClickOutside = (event) => {
    if (
      searchCardContainer.current &&
      !searchCardContainer.current.contains(event.target)
    ) {
      setState({
        open: false,
      });
    }
  };

  useEffect(() => {
    document.addEventListener("mousedown", handleClickOutside.bind(this));
    return () => {
      document.removeEventListener("mousedown", handleClickOutside.bind(this));
    };
  }, []);

  return (
    <form className="searchbox-container">
      <div className="searchbox-elements" ref={searchCardContainer}>
        <div className="searchbox">
          <input
            type="text"
            placeholder="Search.."
            name="search"
            onChange={(e) => setSearchText(e.target.value)}
          ></input>
          <button
            id="btnSearch"
            type="button"
            className="btn btn-primary"
            onClick={handelSearchButtonEvent}
          >
            Search
          </button>
        </div>
        {state.open && (
          <div className="list-container">
            <FilterButton
              name="Metric"
              onClick={handelSearchMetricButton.bind(this)}
            />
            <FilterButton
              name="Service"
              onClick={handelSearchServiceButton.bind(this)}
            />
            <FilterButton
              name="Model"
              onClick={handelSearchModelledButton.bind(this)}
            />
            {/* <div style={{ overflowY: "scroll", height: "51.3vh" }}> */}
              <ul class="list-group" style={{ overflowY: "scroll", height: "51.3vh" }}>
                {state.options.map((item) => (
                  <SeachCard name={item.name} type={item.type} />
                ))}
              </ul>
            </div>
          // </div>
        )}
      </div>
    </form>
  );
}

export default SearchBar;
