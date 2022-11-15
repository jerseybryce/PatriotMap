//Print date
const day = document.querySelector('.day')
const d = new Date()
let date = d.getDay()
var dayName = ''

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
clock.innerHTML = dayName
day.appendChild(clock)


//Print classes
var sidebar = document.querySelector('.classes')
var num = 1

fetch('http://localhost:8080/methods/getClasses')
  .then((response) => response.json())
  .then((data) => {
    while (num < data.length){
        const item = document.createElement('li')
        const div = document.createElement('div')
        const str = '<h3>' + data[num] + '</h3>'
        div.innerHTML = str
        item.appendChild(div)
        sidebar.appendChild(item)
        num += 7
    }
  })

