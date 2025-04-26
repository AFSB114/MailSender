import { useState } from "react";
import "./App.css";

function App() {
  const [email, setEmail] = useState("");
  const [selectedType, setSelectedType] = useState(null);
  const [notification, setNotification] = useState("");

  const emailTypes = [
    { id: "new-account", name: "New Account", icon: "👤", color: "#4CAF50" },
    {
      id: "forgot-pass",
      name: "Forgot Password",
      icon: "🔑",
      color: "#2196F3",
    },
    {
      id: "activation",
      name: "Activation with Code",
      icon: "✅",
      color: "#FF9800",
    },
    {
      id: "changed-pass",
      name: "Password Change Notification",
      icon: "🔐",
      color: "#9C27B0",
    },
    {
      id: "low-stock",
      name: "Low Stock Notification",
      icon: "📦",
      color: "#F44336",
    },
    {
      id: "purchase",
      name: "Purchase Notification",
      icon: "🛒",
      color: "#009688",
    },
  ];

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handleTypeSelect = (type) => {
    setSelectedType(type);
  };

  const sendEmail = () => {
    if (!email) {
      setNotification("Please enter a valid email");
      return;
    }

    if (!selectedType) {
      setNotification("Please select an email type");
      return;
    }

    // Here would be the logic to send the email
    console.log(`Sending ${selectedType.name} email to ${email}`);
    setNotification(`Email type "${selectedType.name}" sent to ${email}`);

    // Reset after sending
    setTimeout(() => {
      setNotification("");
    }, 3000);
  };

  return (
    <div className="container">
      <div className="email-sender-container">
        <h1>Email Sender</h1>

        <div className="input-container">
          <label htmlFor="email">Recipient Email:</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={handleEmailChange}
            placeholder="email@example.com"
          />
        </div>

        <div className="email-types">
          <h2>Select email type:</h2>
          <div className="type-buttons">
            {emailTypes.map((type) => (
              <button
                key={type.id}
                className={`type-button ${
                  selectedType && selectedType.id === type.id ? "selected" : ""
                }`}
                style={{ backgroundColor: type.color }}
                onClick={() => handleTypeSelect(type)}
              >
                <span className="icon">{type.icon}</span>
                <span>{type.name}</span>
              </button>
            ))}
          </div>
        </div>

        <button
          className="send-button"
          onClick={sendEmail}
          disabled={!email || !selectedType}
        >
          Send Email
        </button>

        {notification && <div className="notification">{notification}</div>}
      </div>
    </div>
  );
}

export default App;
