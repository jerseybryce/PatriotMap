const container = document.querySelector('.news')

fetch('http://localhost:8080/news/stories')
    .then(res => res.json())
    .then(data => {
        for (const article of data) {
            const item = document.createElement('li')

            for (const prop in article) {
                const div = document.createElement('div')
                div.innerHTML = article[prop]
                item.appendChild(div)
            }
            
            container.appendChild(item)
        }
    })
