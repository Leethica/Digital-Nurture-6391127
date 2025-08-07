import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(prev => prev + 1);
    sayHello();
    showMessage();
  };

  const sayHello = () => {
    console.log('Hello!');
  };

  const showMessage = () => {
    console.log('You clicked the increment button!');
  };

  const sayWelcome = (msg) => {
    alert(msg);
  };

  const handleClick = (e) => {
    e.preventDefault();
    alert('I was clicked!');
  };

  return (
    <div className="App" style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>🧪 React Event Handling Demo</h1>

      <h2>Counter: {count}</h2>
      <button onClick={increment}>Increment</button>
      <button onClick={() => setCount(prev => prev - 1)}>Decrement</button>

      <hr />

      <button onClick={() => sayWelcome('Welcome to React Events!')}>
        Say Welcome
      </button>

      <hr />

      <button onClick={handleClick}>OnPress (Synthetic Event)</button>

      <hr />

      <CurrencyConvertor />
    </div>
  );
}

export default App;


