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
        for (const cls of data) {
            const div = document.createElement('div')
            div.classList.add('border-bottom')
            div.classList.add('border-dark')
            div.classList.add('border-1')

            var days = ''

            if (cls[0][8] != null){
                days += ' - '
                var d_arr = cls[0][8].split(',')
                console.log(d_arr.length)
                for(let i = 0; i < d_arr.length; i++){
                    if (d_arr[i] == 'Thursday'){
                        days += 'R/'
                    }
                    else{
                        days += d_arr[i].charAt(0) + '/'
                    }
                }

                days = days.slice(0,-1)
            }

            var am_pm = 'AM'
            var class_time = cls[0][7].slice(0,2);
            var tmp = parseInt(class_time)

            if(tmp > 12){
                tmp = tmp % 12
                am_pm = 'PM'
            }

            var location = ''
            if(cls[0][10] != null){
                location += ' @ ' + cls[0][10]
            }

            class_time = tmp.toString() + cls[0][7].slice(2, cls[0][7].length) + ' ' + am_pm
            const str = cls[0][3] + days

            div.style.color = cls[0][6]
            div.innerHTML = str + '<br>' + class_time + location
            div.style.fontSize = "20px"

            sidebar.appendChild(div)
        }
    })
