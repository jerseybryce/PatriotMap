//Print date
const day = document.querySelector('.day')
const d = new Date()
var date = d.getDay()
var dayName = ''
var dd = String(d.getDate()).padStart(2,'0')
var mm = String(d.getMonth() + 1).padStart(2, '0')


switch(date){
    case 0:
        dayName = '<h2>Sunday</h2>'
        break
    case 1:
        dayName = '<h2>Monday</h2>'
        break
    case 2:
        dayName = '<h2>Tuesday</h2>'
        break
    case 3:
        dayName = '<h2>Wednesday</h2>'
        break
    case 4:
        dayName = '<h2>Thursday</h2>'
        break
    case 5:
        dayName = '<h2>Friday</h2>'
        break
    case 6:
        dayName = '<h2>Saturday</h2>'
        break
    default:
        break
}

const clock = document.createElement('div')
clock.innerHTML = dayName + " " + mm + "/" + dd
day.appendChild(clock)


//Print classes
var sidebar = document.querySelector('.classes')
var num = 1

//This is just to read data, can be deleted later
fetch('http://localhost:8080/methods/getClasses')
  .then((response) => response.json())
  .then((data) => console.log(data))

fetch('http://localhost:8080/methods/getClasses')
  .then((response) => response.json())
  .then((data) => {
    while (num < data.length){
        const item = document.createElement('li')
        const div = document.createElement('div')
        const str = '<h3>' + data[num] + '</h3>'
        div.style.color = data[num + 5]
        div.innerHTML = str
        item.appendChild(div)
        sidebar.appendChild(item)
        num += 8
        div.onclick = showBuilding;
    }
  })

function showBuilding (e) {
    console.log(e.target) 
}
