<test-tag>
  <h1>{ opts.title }</h1>
  <ul>
    <li each={ items }>{ title }</li>
  </ul>
  <form onsubmit={ add }>
    <input>
    <button>Add #{ items.length + 1 }</button>
  </form>

  this.items = []
  add(e) {
    var input = e.target[0]
    this.items.push({ title: input.value })
    input.value = ''
  }
</test-tag>
