import React, { useState, useRef } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./Searchbar.css";

const SearchbarDropdown = (props) => {
  const { options, onInputChange } = props;
  const ulRef = useRef();
  const inputRef = useRef();

  return (
    <div className="search-bar-dropdown">
      <form>
        <input
          id="search-bar"
          type="text"
          className="form-control"
          placeholder="Search"
          ref={inputRef}
          onChange={onInputChange}
        />
        <ul id="results" className="list-group" ref={ulRef}>
          {options.map((option, index) => {
            return (
              <button
                type="button"
                key={index}
                onClick={(e) => {
                  inputRef.current.value = option;
                }}
                className="list-group-item list-group-item-action"
              >
                {option}
              </button>
            );
          })}
        </ul>
        <button className="btn btn-primary">Search</button>
      </form>
    </div>
  );
};

const defaultOptions = [];
for (let i = 0; i < 10; i++) {
  defaultOptions.push(`option ${i}`);
  defaultOptions.push(`suggesstion ${i}`);
  defaultOptions.push(`advice ${i}`);
}

function App() {
  const [options, setOptions] = useState([]);
  const onInputChange = (event) => {
    setOptions(
      defaultOptions.filter((option) => option.includes(event.target.value))
    );
  };

  return (
    <div className="container center">
      <div className="row">
        <SearchbarDropdown options={options} onInputChange={onInputChange} />
        <br />
      </div>
    </div>
  );
}

export default App;
