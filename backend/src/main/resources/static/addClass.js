const dropdown = document.querySelector('.building');
var buildingName = 0
var buildingAKA = 1
var buildingID = 2

fetch('http://localhost:8080/methods/getBuildingNames')
  .then((response) => response.json())
  .then((data) => {
    while(buildingAKA < data.length){
        if(data[buildingAKA] != null){
            const option = document.createElement('option')
            var str = data[buildingAKA] + ' - ' + data[buildingName]
            option.value = data[buildingID]
            option.innerHTML = str
            dropdown.appendChild(option)
        }
        buildingName += 3
        buildingAKA += 3
        buildingID += 3
    }
  })
