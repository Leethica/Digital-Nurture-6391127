// src/components/Posts.js
import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
    };
  }

  // Method to fetch posts using Fetch API
  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        const loadedPosts = data.map(
          (item) => new Post(item.userId, item.id, item.title, item.body)
        );
        this.setState({ posts: loadedPosts });
      })
      .catch((error) => {
        this.setState({ hasError: true });
        alert('Failed to load posts: ' + error.message);
      });
  };

  // Lifecycle hook - runs once after component mounts
  componentDidMount() {
    this.loadPosts();
  }

  // Error handling lifecycle hook
  componentDidCatch(error, info) {
    alert('An error occurred while rendering the posts.');
    console.error("Error caught by componentDidCatch:", error, info);
  }

  render() {
    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.length === 0 && <p>Loading posts...</p>}
        {this.state.posts.map((post) => (
          <div key={post.id} style={{ marginBottom: '20px' }}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;

