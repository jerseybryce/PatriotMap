//list classes
var dropdown = document.querySelector('.deleteDropdown')
var classID = 0 //value used to track class ids
var className = 1 //value to track class name

//This is just to read data, can be deleted later
fetch('http://localhost:8080/methods/getClasses')
  .then((response) => response.json())
  .then((data) => console.log(data))

fetch('http://localhost:8080/methods/getClasses')
  .then((response) => response.json())
  .then((data) => {
    for (const cls of data) {
        const option = document.createElement('option')
        option.value = cls[0][2]
        option.innerHTML = cls[0][3]
        dropdown.appendChild(option)
    }
  })
